public static String readFully(Reader reader, int length) throws IOException
{
    char[] buffer = new char[length];
    int totalRead = 0;
    while (totalRead < length)
    {
        int read = reader.read(buffer, totalRead, length-totalRead);
        if (read == -1)
        {
            throw new IOException("Insufficient data");
        }
        totalRead += read;
    }
    return new String(buffer);
}