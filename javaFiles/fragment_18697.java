byte[] b = new byte[BUFFER_LENGTH];
DatagramPacket dgram = new DatagramPacket(b, b.length);
MulticastSocket socket =
  new MulticastSocket(DEST_PORT); // must bind receive side
socket.joinGroup(InetAddress.getByName(MCAST_ADDR));

while(true) {
  socket.receive(dgram); // blocks until a datagram is received
  System.err.println("Received " + dgram.getLength() +
    " bytes from " + dgram.getAddress());
  dgram.setLength(b.length); // must reset length field!
}