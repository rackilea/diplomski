void channel() {
    try {
        SocketChannel sc = SocketChannel.open(new InetSocketAddress("stackoverflow.com", 80));

        ByteBuffer buf = ByteBuffer.allocate(16*1024);
        buf.put(REQUEST.getBytes());
        buf.flip();     // <--------- Here
        sc.write(buf);

        buf.rewind();
        while (sc.read(buf) > 0) {
            buf.flip();   // <------- And here
            System.out.println(new String(buf.array()));
            buf.clear();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}