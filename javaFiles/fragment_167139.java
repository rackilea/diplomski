public static void main( String[] args ) throws Exception {
    byte[] buf = "some data".getBytes();
    MulticastSocket socket = new MulticastSocket();
    socket.setNetworkInterface(NetworkInterface.getByInetAddress(
                                 InetAddress.getByName( "10.10.10.1" )));
    InetAddress address = InetAddress.getByName( "224.0.0.251" );
    socket.send( new DatagramPacket( buf, buf.length, address, 5353) );
}