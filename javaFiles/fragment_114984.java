//how to use storingData?
ByteArrayInputStream in = new ByteArrayInputStream(storingData);
DataInputStream din = new DataInputStream(in);
int v1 = din.readInt();//1234
long v2 = din.readLong();//123L
float v3 = din.readFloat();//1.2f