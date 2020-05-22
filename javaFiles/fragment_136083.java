DatagramSocket socket = new DatagramSocket(25000);
byte[] buf = new byte[512];
DatagramPacket packet = new DatagramPacket(buf, buf.length);
DoubleBuffer db = ByteBuffer.wrap(buf).order(ByteOrder.LITTLE_ENDIAN).asDoubleBuffer();

while (true) {
    socket.receive(packet);
    db.limit(packet.getLength() / Double.BYTES);
    double x = db.get(0);
    System.out.println(x);
}