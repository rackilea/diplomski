//Sending side
ByteArrayOutputStream bout = new ByteArrayOutputStream();
DataOutputStream dout = new DataOutputStream(bout);
dout.writeInt(N);  //this will write 4 bytes
byte[] packetData = bout.toByteArray();

//Receiving side
byte[] packetBuffer = ...;
ByteArrayInputStream bin = new ByteArrayInputStream(packetBuffer);
DataInputStream din = new DataInputStream(bin);
int N = din.readInt();  //This will read only the first 4 bytes, and use the same marshalling as DataOutputStream to produce a consistent value, even if the integer value is something exceptional like infinity or NaN.