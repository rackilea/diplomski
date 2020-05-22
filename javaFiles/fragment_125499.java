SocketChannel sc = 
ByteBuffer bb = ByteBuffer.allocateDirect(1024 *1024); // off heap memory.

while(!Thread.currentThread.isInterrupted()) {
     readLength(bb, 4);
     int length = bb.getInt(0);
     if (length > bb.capacity()) 
         bb = ByteBuffer.allocateDirect(length);
     readLength(bb, length);
     bb.flip();
     // process buffer.
}



static void readLength(ByteBuffer bb, int length) throws EOFException {
     bb.clear();
     bb.limit(length);
     while(bb.remaining() > 0 && sc.read(bb) > 0);
     if (bb.remaining() > 0) throw new EOFException();
}