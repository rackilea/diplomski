byte[] payload = ???;
int payloadSize = payload.length;
ByteBuffer buf = ByteBuffer.allocate(payloadSize + 5);
buf.put((byte) 0);
buf.putInt(payloadSize);
buf.but(payload);