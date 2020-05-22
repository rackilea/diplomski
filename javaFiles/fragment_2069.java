File[] orgFiles = orgDirectory.listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.getPath().endsWith(".gif");
        }
 });