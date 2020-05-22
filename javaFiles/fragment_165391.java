long   value = 123;
byte[] bytes = new byte[8];

ByteBuffer.wrap(bytes).putLong(value);

// bytes now contains the byte representation of 123.