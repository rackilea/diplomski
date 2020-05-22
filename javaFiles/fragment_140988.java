int count;
byte[] buffer = new byte[8192];
while ((count = inStream.read(buffer)) > 0)
{
  outStream.write(buffer, 0, count);
}