DataInputStream dis = new DataInputStream(socket.getInputStream());
String propertiesText = dis.readUTF();
Properties properties = new Properties();
properties.load(new StringReader(propertiesText));
long lengthRemaining = dis.readLong();
FileOutputStream fos = new FileOutputStream(outFilename);
int len;
while(lengthRemaining > 0 
   && (len = dis.read(bytes,0, (int) Math.min(bytes.length, lengthRemaining))) > 0) {
      fos.write(bytes, 0, len);
      lengthRemaining -= len;
}
fos.close();