private static void sendPacket(byte[] data) throws UnknownHostException, IOException {
  // Note, you probably only have to do this once, rather than looking it up every time.
  InetAddress address = InetAddress.getByName(Main.ipAddress);
  DatagramPacket p = new DatagramPacket(data, data.length, address, 10024);
  synchronized(socketLock) {
    socket.send(p);
  }
}