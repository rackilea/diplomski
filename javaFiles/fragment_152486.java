public class DataGram {

    public static void main(String[] args) throws SocketException {
        new Thread(new Client()).start();
        new Thread(new Server()).start();
    }

    static class Client implements Runnable {
        DatagramSocket socket;

        Client() throws SocketException {
            socket = new DatagramSocket(1234);
        }

        @Override
        public void run() {
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                try {
                    socket.receive(packet);
                    String msg = new String(packet.getData());
                    System.out.println(msg);
                } finally {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Server implements Runnable {

        @Override
        public void run() {
            SocketAddress address = new InetSocketAddress("localhost", 1234);
            try (DatagramSocket socket = new DatagramSocket()) {
                String msg = "abcdefghi";
                byte[] buf = msg.getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address);
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}