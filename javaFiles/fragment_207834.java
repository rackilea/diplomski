public static void main(String... args) throws IOException {
    PrintWriter pw = new PrintWriter("abc.log");
    for (int i = 0; i < 100 * 1000; i++) {
        pw.println("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
    }
    pw.close();

    long start2 = System.nanoTime();
    int count2 = 0;
    BufferedReader br = new BufferedReader(new FileReader("abc.log"));
    while (br.readLine() != null) count2++;
    br.close();
    long time2 = System.nanoTime() - start2;
    System.out.printf("IO: Took %,d ms to read %,d lines%n", time2 / 1000 / 1000, count2);

    long start = System.nanoTime();
    FileChannel fc = new FileInputStream("abc.log").getChannel();
    ByteBuffer bb = ByteBuffer.allocateDirect((int) fc.size());
    fc.read(bb);
    fc.close();
    bb.flip();

    CharBuffer cb = ByteBuffer.allocateDirect(bb.remaining() * 2).order(ByteOrder.nativeOrder()).asCharBuffer();
    CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();
    cd.decode(bb, cb, true);
    cb.flip();
    StringBuilder sb = new StringBuilder();
    int count = 0;
    while (cb.remaining() > 0) {
        char ch = cb.get();
        if (isEndOfLine(cb, ch)) {
            // process sb
            count++;
            sb.setLength(0);
        } else {
            sb.append(ch);
        }
    }
    long time = System.nanoTime() - start;
    System.out.printf("NIO as UTF-8: Took %,d ms to read %,d lines%n", time / 1000 / 1000, count);

    long start3 = System.nanoTime();
    FileChannel fc2 = new FileInputStream("abc.log").getChannel();
    MappedByteBuffer bb2 = fc2.map(FileChannel.MapMode.READ_ONLY, 0, fc2.size());
    bb.flip();
    StringBuilder sb3 = new StringBuilder();
    int count3 = 0;
    while (bb2.remaining() > 0) {
        char ch = (char) bb2.get();
        if (isEndOfLine(bb2, ch)) {
            // process sb
            count3++;
            sb3.setLength(0);
        } else {
            sb3.append(ch);
        }
    }
    fc2.close();
    long time3 = System.nanoTime() - start3;
    System.out.printf("NIO as ISO-8859-1: Took %,d ms to read %,d lines%n", time3 / 1000 / 1000, count3);


}

private static boolean isEndOfLine(CharBuffer cb, char ch) {
    if (ch == '\r') {
        if (cb.remaining() >= 1 && cb.get() == '\n') {
            return true;
        }
        cb.position(cb.position() - 1);
        return true;
    } else if (ch == '\n') {
        return true;
    }
    return false;
}

private static boolean isEndOfLine(ByteBuffer bb, char ch) {
    if (ch == '\r') {
        if (bb.remaining() >= 1 && bb.get() == '\n') {
            return true;
        }
        bb.position(bb.position() - 1);
        return true;
    } else if (ch == '\n') {
        return true;
    }
    return false;
}