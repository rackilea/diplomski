public class ExtractAndStart
{
    public static void main(String[] args)
    {
        extractFile("TicTacToe.properties");
        Application.main(args);
    }

    private static void extractFile(String name) throws IOException
    {
        File target = new File(name);
        if (target.exists())
            return;

        FileOutputStream out = new FileOutputStream(target);
        ClassLoader cl = ExtractAndStart.class.getClassLoader();
        InputStream in = cl.getResourceAsStream(name);

        byte[] buf = new byte[8*1024];
        int len;
        while((len = in.read(buf)) != -1)
        {
            out.write(buf,0,len);
        }
        out.close();
            in.close();
    }
}