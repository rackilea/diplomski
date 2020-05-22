public int read() throws IOException
{
  int ch = -1;

  while (in != null && (ch = in.read()) < 0)
    {
      in.close();
      in = getNextStream();
    }

  return ch;
}