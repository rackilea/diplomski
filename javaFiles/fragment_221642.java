DataInputStream dis = 
// read a binary type.
int num = dis.readInt();
int len = dis.readUnsignedShort();
// read a UTF-8 portion.
byte[] bytes = new byte[len];
dis.readFully(bytes);
String text = new String(bytes, "UTF-8");
// read some binary
double d = dis.readDouble();