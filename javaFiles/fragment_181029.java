byte[] allWrittenBytesTest = magicFunctionToAcquireDataFromCassandra();

ByteBuffer bb = ByteBuffer.wrap(allWrittenBytesTest);
bb.order(ByteOrder.BIG_ENDIAN);
bb.rewind();

int size = allWrittenBytesTest.length - 14;
short employeeId = bb.getShort();
long lastModifiedDate = bb.getLong();
int attributeValueLen = bb.getInt();
byte[] attributeValue = new byte[size];
bb.get(attributeValue); // read attributeValue from the remaining buffer