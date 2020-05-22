int count;
byte[] buffer = new byte[8192]; // or 4096, or more
while ((count = in.read(buffer)) > 0)
{
  out.write(buffer, 0, count);
}