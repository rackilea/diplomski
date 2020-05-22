private static final FileFilter filter = new XMLChildFileFilter();

public ExtractedDirectoryWalker() {
    super(filter, -1);
}
private static class XMLChildFileFilter implements FileFilter {
    @Override
    public boolean accept(File file) {
        if(file == null || !file.isDirectory() || !file.canRead()) {
            return false;
        }
        File[] files = file.listFiles();
        for(File f : files) {
            if(f.isFile()) {
                if(FilenameUtils.getExtension(f.getName()).equals("xml"))
                    return true;
            }
        }
        return false;
    }
}