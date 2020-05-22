File dir = new File("saves");
    if (dir.isDirectory()) {
        File[] xmlFiles = dir.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File folder, String name) {
                return name.toLowerCase().endsWith(".xml");
            }
        });
    }