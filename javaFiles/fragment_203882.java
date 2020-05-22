@Override
public int read(byte[] buffer, int start, int length) throws IOException
{
    int ret = input.read(buffer, start, length);
    output.write(buffer, start, ret);
    return ret;
}