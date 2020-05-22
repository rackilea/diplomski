while (in.read(buffer) > 0 || buffer.hasRemaining())
{
  buffer.flip();
  out.write(buffer);
  buffer.compact();
}