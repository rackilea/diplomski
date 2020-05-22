//assuming buffer is a ByteBuffer
buffer.position(0);
buffer.limit(1);
while (buffer.hasRemaining()) { 
   stream.read(buffer);
}
buffer.rewind();

//get the byte and cast it into the range 0-255
int length = buffer.get() & 0xFF;
buffer.clear();
buffer.limit(length);
while (buffer.hasRemaining()) { 
   stream.read(buffer);
}
buffer.rewind();
//the buffer is now ready for reading the data from