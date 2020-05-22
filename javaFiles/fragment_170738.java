File[] txtfiles = directory.listFiles(new FilenameFilter(){
    @Override
    public boolean accept(File dir, String filename)
    {
        return filename.endsWith(".txt");
    }
});