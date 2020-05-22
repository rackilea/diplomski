String[] selectedFiles = fd.getFileNames();
File file = new File(firstFile);
for (int ii = 0; ii < selectedFiles.length; ii++ )
{
    // You've used a FileDialog, so this should always be true
    if (file.isFile())
    {
        // Will always be the first file
        displayFiles(new String[] { file.toString()});
    }
    else
        displayFiles(file.list());
}