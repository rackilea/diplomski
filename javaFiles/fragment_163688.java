File f = new File("."); // current directory

    FilenameFilter textFilter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            String lowercaseName = name.toLowerCase();
            if (lowercaseName.endsWith(".txt")) {
                return true;
            } else {
                return false;
            }
        }
    };

    File[] files = f.listFiles(textFilter);