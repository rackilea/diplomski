public class MulticastReceiver {

private MulticastSocket socket;
private InetAddress address;

public static void main(String[] args) throws InterruptedException {
    new MulticastReceiver();
}

public MulticastReceiver() {
    System.out.println("Starting MulticastReceiver ...");
    try {
        address = InetAddress.getByName(MulticastConstants.MULTICAST_CHANNEL);
        socket = new MulticastSocket(MulticastConstants.MULTICAST_PORT);
        socket.joinGroup(address);

        DatagramPacket packet;
        try {
            byte[] buf = new byte[MulticastConstants.MULTICAST_PACKET_SIZE];
            packet = new DatagramPacket(buf, buf.length);
            System.out.println("Waiting for packets ...");
            socket.receive(packet);
            System.out.println("Received a packet (" + packet.getLength() + " bytes) ...");
            // deserialize packet.getData() to your own object (for simplicity a String is used) ...
            // check if type and serialVersionId are ok, otherwise dispose packet ...
            System.out.println("Server is located at: " + packet.getAddress());
            socket.close();
            // connect to server ...
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } catch (UnknownHostException e) {
        System.out.println("Could not connect to host \"" + address + "\": " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Error initializing: " + e.getMessage());
    }
}
}