ByteBuffer buffer = ByteBuffer.wrap(new byte[]{ 0x01, 0x02, 0x04, 0x08, 0x10 });

buffer.position(1);
buffer.limit(4);

ByteBuffer shared = buffer.slice();