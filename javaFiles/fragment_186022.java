MemoryStream memStream = new MemoryStream(TEMP_BYTE_ARRAY);
BinaryReader reader = new BinaryReader(memStream);

//read data
double a = reader.ReadDouble();
int b = reader.ReadInt();
string c = reader.ReadString();