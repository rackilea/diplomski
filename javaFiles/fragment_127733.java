byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
writer.writeInt(bytes.length)
writer.write(bytes, 0, bytes.length);  

int len = reader.readInt();
byte[] bytes = new byte[len];
reader.read(bytes, 0, len);
String str = new String(bytes, StandardCharsets.UTF_8);