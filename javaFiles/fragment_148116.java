try (InputStream is = new FileInputStream("effect_0.cube")) {
    ByteBuffer buf = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
    for (int len; (len = is.read(buf.array())) == 4; ) {
        buf.rewind();
        float f = buf.getFloat();
        System.out.println(f);
    }
}