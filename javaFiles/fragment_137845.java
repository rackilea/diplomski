File file = new File("myDirectory");
String[] myTextFiles = file.list(new FilenameFilter() {
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".txt"); // Andrew Thompson's comment
    }
});