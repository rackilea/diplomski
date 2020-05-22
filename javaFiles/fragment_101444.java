File root = new File(yourDirectory);
File[] files = root.listFiles(new FileFilter() {
    @Override
    public boolean accept(File file) {
        return !file.isHidden();
    }
});