File file = new File("path");
File[] subdirs = file.listFiles(new FileFilter() {
    public boolean accept(File f) {
        return f.isDirectory();
    }
});