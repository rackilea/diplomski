FileFilter fileFilter = new FileFilter() {
    @Override
    public boolean accept(File pathname)
    {
        return ! pathname.getPath().endsWith("-path.mp4");
    }
};