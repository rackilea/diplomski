byte data[] = ...;
DataInput input = new DataInputStream(new ByteArrayInputStream(data));

int cmd = input.readInt();
int args = input.readInt();
int flags = input.readInt();