File root = new File("C:\\");

    File[] files = root.listFiles(new FileFilter() {
        @Override
        public boolean accept(File file) {
            Path path = Paths.get(file.getAbsolutePath());
            DosFileAttributes dfa;
            try {
                dfa = Files.readAttributes(path, DosFileAttributes.class);
            } catch (IOException e) {
                // bad practice
                return false;
            }
            return (!dfa.isHidden() && !dfa.isSystem());
        }
    });