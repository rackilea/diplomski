boolean transfer(InputStream is, OutputStream os) throws IOException
{
    byte buffer[] = new byte[2048];
    int count;
    while ((count = is.read(buffer)) != -1)
        os.write(buffer, 0, count);
}