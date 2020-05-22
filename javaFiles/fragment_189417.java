int file_size = ...;
byte[] file_data = ...;

byte[] packet = new byte[file_size + 4];
ByteBuffer.wrap(packet).order(ByteOrder.LITTLE_ENDIAN).putInt(file_size);
System.arraycopy(file_data, 0, packet, 4, file_size);