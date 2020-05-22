int size = 2 + 8 + 4 + attributeValue.length; // short is 2 bytes, long 8 and int 4

ByteBuffer bbuf = ByteBuffer.allocate(size); 
bbuf.order(ByteOrder.BIG_ENDIAN);

bbuf.putShort(employeeId);
bbuf.putLong(lastModifiedDate);
bbuf.putInt(attributeValue.length);
bbuf.put(attributeValue);

bbuf.rewind();

// this is a bad approach because if you modify the returned array
// you are directly modifying the ByteBuffer's internal array.
byte[] bytesToStore = bbuf.array();

// best approach is copy the internal buffer
byte[] bytesToStore = new byte[size];
bbuf.get(bytesToStore);