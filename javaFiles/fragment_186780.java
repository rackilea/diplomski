File f = new File("/etc/");
    File[] allReleaseFiles = f.listFiles(new FilenameFilter() {

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith("-release");
        }
    });