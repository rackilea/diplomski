public static class MyStruct {
    public int foo;
    public boolean bar = true;
    public final byte[] byteArray = new byte[3];
}

public static void main(String[] args) throws IOException {
    LegacyFileHandler handler = new LegacyFileHandler();
    MyStruct struct = new MyStruct();

    RandomAccessFile file = new RandomAccessFile("foo", "rw");
    try {
        for (int i = 0; i < 4; i++) {
            struct.foo = i;
            handler.write(file, struct);
        }

        struct = readRecord(file, handler, 2);
        System.out.println(struct.foo);
    } finally {
        file.close();
    }
}

private static MyStruct readRecord(RandomAccessFile file,
        LegacyFileHandler handler, int n) throws IOException {
    MyStruct struct = new MyStruct();

    long pos = n * handler.sizeOf(struct);
    file.seek(pos);

    handler.read(file, struct);

    return struct;
}