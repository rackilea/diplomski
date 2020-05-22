public class SocketManager {
    private static final Random random = new Random();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final Map<Datacenters, List<SocketHolder>> liveSocketsByDatacenter = new ConcurrentHashMap<>(); // use ConcurrentHashMap
    private final ZContext ctx = new ZContext();

    // ...

    private SocketManager() {
      connectToZMQSockets();
      scheduler.scheduleAtFixedRate(this::updateLiveSockets, 30, 30, TimeUnit.SECONDS);
    }

    // during startup, making a connection and populate once
    private void connectToZMQSockets() {
      Map<Datacenters, List<String>> socketsByDatacenter = Utils.SERVERS;
      for (Map.Entry<Datacenters, List<String>> entry : socketsByDatacenter.entrySet()) {
        List<SocketHolder> addedColoSockets = connect(entry.getValue(), ZMQ.PUSH);
        liveSocketsByDatacenter.put(entry.getKey(), addedColoSockets); // we can put it straight into the map
      }
    }

    // ...      

    // this method will be called by multiple threads to get the next live socket
    // is there any concurrency or thread safety issue or race condition here?
    public Optional<SocketHolder> getNextSocket() {
      for (Datacenters dc : Datacenters.getOrderedDatacenters()) {
        Optional<SocketHolder> liveSocket = getLiveSocket(liveSocketsByDatacenter.get(dc)); // no more need for a local copy, ConcurrentHashMap, makes sure I get the latest mapped List<SocketHolder>
        if (liveSocket.isPresent()) {
          return liveSocket;
        }
      }
      return Optional.absent();
    }

    // is there any concurrency or thread safety issue or race condition here?
    private Optional<SocketHolder> getLiveSocket(final List<SocketHolder> listOfEndPoints) {
      if (!CollectionUtils.isEmpty(listOfEndPoints)) {
        // The list of live sockets
        List<SocketHolder> liveOnly = new ArrayList<>(listOfEndPoints.size());
        for (SocketHolder obj : listOfEndPoints) {
          if (obj.isLive()) {
            liveOnly.add(obj);
          }
        }
        if (!liveOnly.isEmpty()) {
          // The list is not empty so we shuffle it an return the first element
          return Optional.of(liveOnly.get(random.nextInt(liveOnly.size()))); // just pick one
        }
      }
      return Optional.absent();
    }

    // no need to make this synchronized
    private void updateLiveSockets() {
      Map<Datacenters, List<String>> socketsByDatacenter = Utils.SERVERS;

      for (Map.Entry<Datacenters, List<String>> entry : socketsByDatacenter.entrySet()) {
        List<SocketHolder> liveSockets = liveSocketsByDatacenter.get(entry.getKey());
        List<SocketHolder> liveUpdatedSockets = new ArrayList<>();
        for (SocketHolder liveSocket : liveSockets) { // LINE A
          Socket socket = liveSocket.getSocket();
          String endpoint = liveSocket.getEndpoint();
          Map<byte[], byte[]> holder = populateMap();
          Message message = new Message(holder, Partition.COMMAND);

          boolean status = SendToSocket.getInstance().execute(message.getAdd(), holder, socket);
          boolean isLive = (status) ? true : false;

          SocketHolder zmq = new SocketHolder(socket, liveSocket.getContext(), endpoint, isLive);
          liveUpdatedSockets.add(zmq);
        }
        liveSocketsByDatacenter.put(entry.getKey(), Collections.unmodifiableList(liveUpdatedSockets)); // just put it straigth into the map, the mapping will be updated in a thread safe manner.
      }
    }

}