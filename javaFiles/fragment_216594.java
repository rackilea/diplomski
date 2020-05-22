public static byte[] intsToBytes(int[] ints) {
    ByteBuffer bb = ByteBuffer.allocate(ints.length * 4);
    IntBuffer ib = bb.asIntBuffer();
    for (int i : ints) ib.put(i);
    return bb.array();
}

public static int[] bytesToInts(byte[] bytes) {
    int[] ints = new int[bytes.length / 4];
    ByteBuffer.wrap(bytes).asIntBuffer().get(ints);
    return ints;
}