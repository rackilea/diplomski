CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();
    ByteBuffer in = ByteBuffer.wrap(bytes);
    CharBuffer out = CharBuffer.allocate(1);
    int p = 0;
    while (in.hasRemaining()) {
        cd.decode(in, out, true);
        char c = out.array()[0];
        int nBytes = in.position() - p;
        p = in.position();
        out.position(0);
    }