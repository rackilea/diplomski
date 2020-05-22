final ByteBuffer buf = ByteBuffer.allocate(1024);
for (final byte ch : phrase.getBytes("UTF-8")) {
    buf.put(ch);
}
// or just
buf.put( phrase.getBytes("UTF-8"));