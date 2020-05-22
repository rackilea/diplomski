File file = new File("/tmp");
File[] files = file.listFiles(new FileFilter() {
    @Override
    public boolean accept(File f) {
        return f.isDirectory();
    }
});
System.out.println("Folders count: " + files.length);