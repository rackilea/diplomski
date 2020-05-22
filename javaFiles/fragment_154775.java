private List<File> getMatchingFiles(File parent, final String extension) {
    File[] files = parent.listFiles(new FileFilter() {

        public boolean accept(File dir) {
            String name = dir.getName();
            if(name.endsWith(extension)) {
                return true;
            }
        }
    });

    List<File> retval = Arrays.asList( files );
    return retval;
}