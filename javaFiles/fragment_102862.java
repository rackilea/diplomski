public static void main(String[] args) throws IOException
{
    InputStream i = new FileInputStream("a.mp3");
    byte[] contents = new byte[i.available()];
    i.read(contents);
    i.close();
}