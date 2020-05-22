Socket s; // assume this is already connected
SocketChannel = s.getChannel();
ByteBuffer buf = ByteBuffer.allocate(8); // two 4-byte integers
buf.put( 1 ).putInt( 0 );
buf.flip();
c.write( buf ); // assuming channel is writable :)