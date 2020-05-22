String[] filenames = dialog.getFileNames();
String filterPath = dialog.getFilterPath();

File[] selectedFiles = new File[filenames.length];

for(int i = 0; i < filenames.length; i++)
{
    if(filterPath != null && filterPath.trim().length() > 0)
    {
        selectedFiles[i] = new File(filterPath, filenames[i]);
    }
    else
    {
        selectedFiles[i] = new File(filenames[i]);
    }
}