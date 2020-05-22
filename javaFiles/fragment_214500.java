ByteArrayOutputStream baos = new ByteArrayOutputStream();
byte buffer[] = new byte[1024];
for(int s; (s=in.read(buffer)) != -1; )
{
  baos.write(buffer, 0, s);
}
byte result[] = baos.toByteArray();