public static void main(String... args) throws IOException, InterruptedException {
    ServerSocketChannel ssc = ServerSocketChannel.open();
    ssc.bind(new InetSocketAddress(0)); // open on a random port
    InetSocketAddress remote = new InetSocketAddress("localhost", ssc.socket().getLocalPort());
    SocketChannel sc = SocketChannel.open(remote);
    configure(sc);
    SocketChannel accept = ssc.accept();
    configure(accept);

    ByteBuffer bb = ByteBuffer.allocateDirect(16 * 1024 * 1024);
    // write as much as you can
    while (sc.write(bb) > 0)
        Thread.sleep(1);
    System.out.println("The socket write wrote " + bb.position() + " bytes.");
}

private static void configure(SocketChannel socketChannel) throws IOException {
    socketChannel.configureBlocking(false);
    socketChannel.socket().setSendBufferSize(8);
    socketChannel.socket().setReceiveBufferSize(8);
}