// Create a buffer where we'll put the data to send
ByteBuffer sendBuffer = ByteBuffer.allocate(4 + data.length);
sendBuffer.order(ByteOrder.BIG_ENDIAN); // it's the default, but included for clarity

// Put the 4-byte length, then the data itself
sendBuffer.putInt(data.length);
sendBuffer.put(data);

// Extract the actual bytes from our sendBuffer
byte[] dataToSend = sendBuffer.array();