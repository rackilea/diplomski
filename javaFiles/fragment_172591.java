// assuming myDir is the File object that represents the directory
File[] dirContent = myDir.listFiles();
for (File f : dirContent)
{
    if (!f.isDirectory())
    {
        // process file.
    }
}