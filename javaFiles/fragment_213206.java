File theDirectory = new File("/home/example");
File[] children = theDirectory.listFiles(new FileFilter(){
    public boolean accept(File file) {
        if (file.isFile()) {
           //Check other conditions
           return true;
        }
        return false;
    }
});