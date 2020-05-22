ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

DataOutputStream dout = new DataOutputStream(byteStream);

dout.writeInt( 0x13 ); // L:4
dout.write( 6 ); // L:5
dout.writeShort( index ); // guess, L:7
dout.writeLong( begin ); // >4GB support? L:15
dout.writeInt( length ); // clients accept below to 2^17, L:19

dout.flush(); // to be sure

message = byteStream.toByteArray();