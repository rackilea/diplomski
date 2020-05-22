private void getDir(String dirPath){

    File f = new File(dirPath);
    File[] files = f.listFiles();
    CharSequence[] items = new CharSequence[files.length];
    for (int i=0; i< files.length; i++)
        items[i]=files[i].getPath();
}