public static void main(String args[]) throws IOException {
    InetAddress inetAddress = InetAddress.getByName("239.255.42.99");
    int PORT = 2225;
    int BUFFER_SIZE = 10;
    DatagramSocket datagramSocket = new DatagramSocket();
    byte[] buf = new byte[BUFFER_SIZE];
    String message = "0123456789";
    buf = message.getBytes();
    DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, inetAddress, PORT);

    datagramSocket.send(datagramPacket);
    datagramSocket.setSoTimeout(1010);
}