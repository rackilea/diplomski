File directory = new File("C:\temp");
File[] files = directory.listFiles();
for (File f : files)
{
    if (f.getName().startsWith("LOG_EXPORT_TIME_STAMP_IMAGES"))
    {
      f.delete();
    }
}