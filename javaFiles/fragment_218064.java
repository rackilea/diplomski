// the true size is always a multiple of a page anyway.
static final ByteBuffer buffer = ByteBuffer.allocateDirect(4096); 

// synchronize the buffer if you need to, or use a ThreadLocal buffer as a simple cache.
byte[] bytes = m_packet.getByteArray(0, m_packet.size());
buffer.clear();
buffer.put(bytes);
buffer.flip();