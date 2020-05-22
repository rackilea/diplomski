int count;
byte[] buffer = new byte[8192]; // or more, but megabytes is pointless as the network will packetize anyway
while ((count = in.read(buffer)) > 0)
{
  out.write(buffer, 0, count);
}