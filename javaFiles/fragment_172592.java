// assuming myDir is the File object that represents the directory
File[] dirContent = myDir.listFiles(new FileFilter() {
    @Override boolean accept(File pathname)
    {
        return !pathname.isDirectory();
    }
});
for (File f : dirContent)
{
    // process file.
}