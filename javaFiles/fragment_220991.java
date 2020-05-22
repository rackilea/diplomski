if (!dir.exists())
{
    try
    {
        dir.mkdirs();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}