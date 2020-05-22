ByteArrayOutputStream out = new ByteArrayOutputStream();
DataOutputStream dout = new DataOutputStream(out);
dout.writeInt(1234);
dout.writeLong(123L);
dout.writeFloat(1.2f);
byte[] storingData = out.toByteArray();