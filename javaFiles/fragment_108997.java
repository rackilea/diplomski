SocketChannel sc = 
ByteBuffer bb= ByteBuffer.allocateDirect(1024).order(ByteOrder.LITTLE_ENDIAN);

bb.putInt(1);
// put whatever else
bb.flip();
while(bb.remaining() > 0) sc.write(bb);