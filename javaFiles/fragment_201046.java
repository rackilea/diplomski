public class FileCreator
{
    public static void main(String... args)
    {
        new FileCreator().go();
    }

    public void go()
    {
        FileWriter fileWriter = null;
        try
        {
            File file = new File("d:/tempm/watch/" + System.currentTimeMillis() + ".jar");
            fileWriter = new FileWriter(file);
            for (int counter = 0; counter < 100; counter++)
            {
                // first write
                fileWriter.write(String.valueOf(System.nanoTime()));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(fileWriter != null)
            {
                try
                {
                    // data is flushed and file handles are closed
                    fileWriter.flush();
                    fileWriter.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}