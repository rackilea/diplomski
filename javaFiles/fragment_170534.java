ByteBuffer buffer = ByteBuffer.wrap(data);
buffer.order(ByteOrder.LITTLE_ENDIAN);
double st = buf.getShort();
double accX = buf.getShort();
double accY = buf.getShort();
...
double et = buf.getShort();