Socket s = .....;

InputStream in = s.getInputStream();
byte [] buf = new byte[12];

// read 12 bytes from socket into bytes
in.read(buf);

ByteBuffer bb = ByteBuffer.allocate(buf.length);
bb.order(ByteOrder.LITTLE_ENDIAN);
bb.put(buf);
bb.flip();
short short1 = bb.getShort();
long long1 = bb.getLong();
short short2 = bb.getShort();