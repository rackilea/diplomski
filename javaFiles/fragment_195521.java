public static void main(String[] args) {
    short x = 1192;
    short y = 27877;
    ByteBuffer bb = ByteBuffer.allocate(8);
    bb.clear();
    bb.putShort((short) 0);
    bb.putShort((short) 0);
    bb.putShort(x);
    bb.putShort(y);
    bb.flip();
    System.out.println("" + bb.getLong());
}