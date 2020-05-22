// buffer which grows as needed.
ByteArrayOutputStream boas = new ByteArrayOutputStream();
// supports basic data types
DataOutputStream dos = new DataOutputStream(baos);
dos.writeInt(data.length);
for(int i: data) dow.writeInt(i);
// write the length of the string + the UTF-8 encoding of the text.
dos.writeUTF(s1);
dos.writeUTF(s2);
byte[] bytes = bytes.toByteArray();