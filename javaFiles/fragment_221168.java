ByteArrayOutputStream dataBuffer = new ByteArrayOutputStream();
InputStream in = s.getInputStream();
int readLength;
byte buffer[] = new byte[1024];
while ((readLength = in.read(buffer, 0, buffer.length)) != -1) {
  dataBuffer.write(buffer, 0, readLength);
}
byte bitmapdata[] = dataBuffer.toByteArray();