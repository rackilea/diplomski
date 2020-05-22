DatagramSocket socket = new DatagramSocket();

byte[] b = new byte[DGRAM_LENGTH];
DatagramPacket dgram;

dgram = new DatagramPacket(b, b.length,
  InetAddress.getByName(MCAST_ADDR), DEST_PORT);

System.err.println("Sending " + b.length + " bytes to " +
  dgram.getAddress() + ':' + dgram.getPort());
while(true) {
  System.err.print(".");
  socket.send(dgram);
  Thread.sleep(1000);
}