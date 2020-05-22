byte[] somebytes = { 1, 5, 5, 0, 1, 0, 5 };
ByteBuffer bb = ByteBuffer.wrap(somebytes);
int first = bb.getShort(); //pull off a 16 bit short (1, 5)
int second = bb.get(); //pull off the next byte (5)
int third = bb.getInt(); //pull off the next 32 bit int (0, 1, 0, 5)
System.out.println(first + " " + second + " " + third);

Output
261 5 65541