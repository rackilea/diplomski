public static void main(String[] args) {
    ByteBuffer bb = ByteBuffer.wrap(new byte[] { 0, 0, 0, -34 });
    System.out.println(bb.order());
    System.out.println(bb.getInt() == 222);
    bb.rewind();
    bb.order(ByteOrder.LITTLE_ENDIAN);
    System.out.println(bb.order());
    System.out.println(bb.getInt() == -570425344);
}