int count = 0;
getFile("/mnt/sdcard/folder/");

private void getFile(String dirPath) {
    File f = new File(dirPath);
    File[] files = f.listFiles();

    if (files != null)
    for (int i = 0; i < files.length; i++) {
        count++;
        File file = files[i];

        if (file.isDirectory()) {   
             getFile(file.getAbsolutePath()); 
        }
    }
}