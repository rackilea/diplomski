byte[] header = new byte[8];
readFully(in, header, 0, header.length);

int device = readByte(header, 1);
int par = readByte(header, 5);
int sizeData = readShort(header, 6);

byte[] data = new byte[sizeData];
readFully(in, data, 0, sizeData);
// now we have the whole data