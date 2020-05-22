if (path.endsWith(File.separator)) 
{
    filename = path + filename;
} 
else 
{
    filename = path + File.separator + filename;
}

pdf = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath() + "/PATH/" + filename);
Uri path = Uri.fromFile(pdf);