File f1 = new File("/path/to/folder1");
File f2 = new File("/path/to/folder2");

FilenameFilter filter = new FilenameFilter()
{
    @Override public boolean accept(File dir, String name)
    {
        return name.endsWith(".zip");
    }
};

for (File f : f1.listFiles(filter))
{
    // TODO move to folder2
}