// using NIO
SocketChannel sc = SocketChannel.open(new InetSocketAddress("localhost", 12345));
ByteBuffer bb = ByteBuffer.allocateDirect(32*1024).order(ByteBuffer.LITTE_ENDIAN));
while(sc.read(bb) >= 0) {
    bb.flip();
    while(bb.remaining() > 1) {
       int num = bb.getShort() & 0xFFFF;
    }
    bb.compact();
}