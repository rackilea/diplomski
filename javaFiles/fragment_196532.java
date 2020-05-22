// use a FilenameFilter to have only the pictures in JPG
aFile = fPath.listFiles(new FilenameFilter() {
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".jpg");
    }
});