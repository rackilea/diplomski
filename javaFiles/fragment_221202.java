DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
Properties fileProperties = new Properties();
File file = new File(filename);

// send the properties
StringWriter writer = new StringWriter();
fileProperties.store(writer, "");
writer.close();
dos.writeUTF(writer.toString());

// send the length of the file
dos.writeLong(file.length());

// send the file.
byte[] bytes = new byte[8*1024];
FileInputStream fis = new FileInputStream(file);
int len;
while((len = fis.read(bytes))>0) {
    dos.write(bytes, 0, len);
}
fis.close();
dos.flush();