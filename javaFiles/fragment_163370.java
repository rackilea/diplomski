public static final String HOST_DST = "148.140.60.29";
public static final int    PORT_DST = 2416;
public static final int    PORT_SRC = 2802;

void method() {
   DatagramSocket    sock    = new DatagramSocket( PORT_SRC );
   InetSocketAddress dst     = new InetSocketAddress( HOST_DST, PORT_DST );
   ByteBuffer        message = ByteBuffer.allocate( MESSAGE_SIZE );
   for(...) {
      message.clear();
      message.putFloat( ... );
      message.putInt( ... );
      ...
      message.flip();
      sock.send( new DatagramPacket( message.array(), message.limit(), dst ));
   }
}