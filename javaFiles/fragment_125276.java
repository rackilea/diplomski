public class PacketReader implements Runnable {

    private ILogger logger;
    private final Queue<Packet> queue;
    private String multicastIpAddress;
    private int multicastPortNumber;
    private boolean running = true;

    public PacketReader(ILogger logger, Queue<Packet> queue, String multicastIpAddress, int multicastPortNumber) {
        this.logger = logger;
        this.queue = queue;
        this.multicastIpAddress = multicastIpAddress;
        this.multicastPortNumber = multicastPortNumber;
    }

    public void stop() {
        running = false;
    }

    public void run() {
        InetAddress multicastAddress = null;
        MulticastSocket multicastSocket = null;
        try {
            multicastAddress = InetAddress.getByName(multicastIpAddress);
            multicastSocket = new MulticastSocket(multicastPortNumber);
            String hostname = InetAddress.getLocalHost().getHostName();
            byte[] buffer = new byte[8192];
            multicastSocket.joinGroup(multicastAddress);
            System.out.println("Listening from " + hostname + " at " + multicastAddress.getHostName());
            int numberOfPackets = 0;

            while (running) {
                numberOfPackets++;
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
                multicastSocket.receive(datagramPacket);
                Packet packet = new Packet(numberOfPackets, datagramPacket);
                queue.add(packet);
            }
        } catch (SocketException socketException) {
            System.out.println("Socket exception " + socketException);
        } catch  (IOException exception) {
            System.out.println("Exception " + exception);
        } finally {
            if (multicastSocket != null) {
                try {
                    multicastSocket.leaveGroup(multicastAddress);
                    multicastSocket.close();
                } catch (IOException exception) {
                    System.out.println(exception.toString());
                }
            }
        }
    }
}