String folder_main = "My Dir";

    File f = new File(Environment.getExternalStorageDirectory(), folder_main);
    if (!f.exists()) {
        f.mkdirs();
    }
    File test = new File(f , "testFile.txt");