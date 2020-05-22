public BigInteger toBigInteger(int[] data) {
    byte[] array = new byte[data.length * 4];
    ByteBuffer bbuf = ByteBuffer.wrap(array);
    IntBuffer ibuf = bbuf.asIntBuffer();
    ibuf.put(data);
    return new BigInteger(array);
}