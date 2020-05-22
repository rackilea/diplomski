String baseFolder;
// check if external storage is available
if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
    baseFolder = context.getExternalFilesDir(null).getAbsolutePath()
}
// revert to using internal storage
else {
    baseFolder = context.getFilesDir().getAbsolutePath();
}

String string = "hello world!";
File file = new File(basefolder + "test.txt");
FileOutputStream fos = new FileOutputStream(file);
fos.write(string.getBytes());
fos.close();