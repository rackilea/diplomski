File file = new File(dir, "log.txt");
if (!file.exists())
{
    try
    {
        file.createNewFile();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}