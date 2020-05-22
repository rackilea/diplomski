f.list(new FilenameFilter() {

    @Override
    public boolean accept(File dir, String name) {
        name.endsWith(".txt");
        return false;
    }
});