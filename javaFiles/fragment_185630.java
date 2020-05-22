int count;
byte[] buffer = new byte[8192]; // or more if you like
while ((count = in.read(buffer)) > 0)
{
  out.write(buffer, 0, count);
}