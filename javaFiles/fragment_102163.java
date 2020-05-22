ByteArrayOutputStream baos = new ByteArrayOutputStream();
byte[] buf = new byte[1024];
int read;
while ((read=in.read(buf))!=-1) {
  baos.write(buf, 0, read);
}
byte[] output = baos.toByteArray();