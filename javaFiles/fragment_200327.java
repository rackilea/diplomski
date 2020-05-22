// Your variable is no more final, it is now volatile to ensure that all 
// threads will see the same thing at all time by getting it from
// the main memory instead of the CPU cache
private volatile Map<Datacenters, List<SocketHolder>> liveSocketsByDatacenter 
    = Collections.unmodifiableMap(new HashMap<>());

private void connectToZMQSockets() {
    Map<Datacenters, ImmutableList<String>> socketsByDatacenter = Utils.SERVERS;
    // The map in which I put all the live sockets
    Map<Datacenters, List<SocketHolder>> liveSockets = new HashMap<>();
    for (Map.Entry<Datacenters, ImmutableList<String>> entry : 
        socketsByDatacenter.entrySet()) {

        List<SocketHolder> addedColoSockets = connect(
            entry.getKey(), entry.getValue(), ZMQ.PUSH
        );
        liveSockets.put(entry.getKey(), Collections.unmodifiableList(addedColoSockets));
    }
    // Set the new content of my map as an unmodifiable map
    this.liveSocketsByDatacenter = Collections.unmodifiableMap(liveSockets);
}

public Optional<SocketHolder> getNextSocket() {
    // For the sake of consistency make sure to use the same map instance
    // in the whole implementation of my method by getting my entries
    // from the local variable instead of the member variable
    Map<Datacenters, List<SocketHolder>> liveSocketsByDatacenter = 
        this.liveSocketsByDatacenter;
    ...
}
...
// Added the modifier synchronized to prevent concurrent modification
// it is needed because to build the new map we first need to get the
// old one so both must be done atomically to prevent concistency issues
private synchronized void updateLiveSockets() {
    // Initialize my new map with the current map content
    Map<Datacenters, List<SocketHolder>> liveSocketsByDatacenter = 
        new HashMap<>(this.liveSocketsByDatacenter);
    Map<Datacenters, ImmutableList<String>> socketsByDatacenter = Utils.SERVERS;
    // The map in which I put all the live sockets
    Map<Datacenters, List<SocketHolder>> liveSockets = new HashMap<>();
    for (Entry<Datacenters, ImmutableList<String>> entry : socketsByDatacenter.entrySet()) {
        ...
        liveSockets.put(entry.getKey(), Collections.unmodifiableList(liveUpdatedSockets));
    }
    // Set the new content of my map as an unmodifiable map
    this.liveSocketsByDatacenter = Collections.unmodifiableMap(liveSocketsByDatacenter);
}