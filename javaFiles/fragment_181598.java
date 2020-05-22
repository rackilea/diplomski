String baseFolder;
// check if external storage is available
if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
    baseFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
}
// revert to using internal storage (not sure if there's an equivalent to the above)
else {
    baseFolder = context.getFilesDir().getAbsolutePath();
}

String string = "hello world!";
File file = new File(basefolder + File.separator + "test.txt");
file.getParentFile().mkdirs();
FileOutputStream fos = new FileOutputStream(file);
fos.write(string.getBytes());
fos.flush();
fos.close();