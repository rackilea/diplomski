public class ReadFile1
{
    public static void main(String[] a) throws IOException
    {
        FileWriter fstream = new FileWriter("C:\\test.txt",true);
        BufferedWriter out = new BufferedWriter(fstream);

        showDir(out,1,new File("C:\\"));

        out.flush();
        out.close();
    }

    static void showDir(BufferedWriter writer, int indent, File file) throws IOException
    {
        for(int i = 0; i < indent; i++)
        {
            writer.write('-');
            //System.out.print('-');
        }

        writer.write(file.getName() + " - " + file.length() / 1024 + " KB");
        writer.newLine();

        //System.out.println(file.getName() + " - " + file.length() / 1024 + " KB");

        if(file.isDirectory())
        {
            File[] files = file.listFiles();
            for(int i = 0; i < files.length; i++)
            {
                showDir(writer,indent + 4, files[i]);
            }
        }
    }
}