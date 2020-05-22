private static final int A_SIZE = 8;
private static final int B_SIZE = 4 + GLOBALLENGTH * 8;

public byte[] writeA(A a) {
    byte[] bytes = new byte[A_SIZE];
    writeA(a, bytes, 0);
    return bytes;
}

private void writeA(A a, byte[] bytes, int offset) {
    ByteBuffer buff = ByteBuffer.wrap(bytes, offset, A_SIZE);
    buff.order(ByteOrder.LITTLE_ENDIAN);
    buff.putInt(a.field1).putInt(a.field2);
}

public byte[] writeB(B b) {
    byte[] bytes = new byte[B_SIZE];
    ByteBuffer buff = ByteBuffer.wrap(bytes, 0, 4);
    buff.order(ByteOrder.LITTLE_ENDIAN);
    buff.putInt(b.length);
    int offset = 4;
    for (A a : b.list) {
        writeA(a, bytes, offset);
        offset += A_SIZE;
    }
    return bytes;
}