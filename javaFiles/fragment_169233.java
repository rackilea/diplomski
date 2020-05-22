public static void main(String[] args) {
    byte[] ba = "Hello Wolrd!".getBytes(StandardCharsets.US_ASCII);
    ByteBuffer bb = ByteBuffer.allocateDirect(ba.length + 1); // for terminator
    bb.put(ba);
    callCPP(bb);
}

private static native void callCPP(ByteBuffer bytes);