String data = "Hello, world!";

ByteBuffer buffer = ByteBuffer.allocate(data.length + Integer.BYTES);
buffer.putInt(data.length);    
buffer.put(data.getBytes("UTF-8"));
buffer.flip();

channel.write(buffer);