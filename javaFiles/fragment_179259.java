class MyClass {
    private SelectableChannel channel; // either a SocketChannel or a DatagramChannel

    public int readStuff(ByteBuffer buffer) {
        // Cast it to a ByteChannel when necessary
        return ((ByteChannel) channel).read(buffer);
    }
}