void deleteFiles(String folder, String ext)
{
    File dir = new File(folder);
    if (!dir.exists())
        return;
    File[] files = dir.listFiles(new GenericExtFilter(ext));
    for (File file : files)
    {
        if (!file.isDirectory())
        {
            boolean result = file.delete();
            Log.d("TAG", "Deleted:" + result);
        }
    }
}