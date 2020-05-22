// Allocate a big endian byte buffer
ByteBuffer bb = ByteBuffer.allocate(4096);
bb.order(ByteOrder.BIG_ENDIAN);
bb.putShort(12345);

// Write the buffer to an NIO channel
bb.flip();
channel.write(bb);