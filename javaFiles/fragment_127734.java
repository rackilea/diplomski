byte[] lenBytes = BitConverter.GetBytes(strBytes.Length);
Array.Reverse(lenBytes);
writer.Write(lenBytes);

byte[] lenBytes = reader.ReadBytes(4);
Array.Reverse(lenBytes);
int len = BitConverter.ToInt32(lenBytes);