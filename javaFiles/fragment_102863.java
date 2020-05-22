public static void main(String[] args) throws IOException
{
    File f = new File("c:\\msdia80.dll");
    InputStream i = new FileInputStream(f);
    byte[] contents = new byte[(int) f.length()];

    int read;
    int pos = 0;
    while ((read = i.read(contents, pos, contents.length - pos)) >= 1)
    {
        pos += read;
    }
    i.close();
}