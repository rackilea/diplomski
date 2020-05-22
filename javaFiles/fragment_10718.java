private static byte[] xform(long[] la, ByteOrder order) {
    ByteBuffer bb = ByteBuffer.allocate(la.length * 8);
    bb.order(order);
    bb.asLongBuffer().put(la);
    return bb.array();
}