public String getLatestMatchedFilename(String path, final String name) {
    File dir = new File(path);    
    File[] files = dir.listFiles(new FilenameFilter() {
        public boolean accept(File dir, String nameFilter) {
            return nameFilter.startsWith(name);
        }
    });
    // rest of your code ...
}