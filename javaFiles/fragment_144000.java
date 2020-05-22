File folder = new File("./WebContent/datasets/DB_Set/");
        File[] listOfSubDirectories = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        ArrayList<File> filesList = new ArrayList<File>();
        for (File dir : listOfSubDirectories) {
            File[] files = dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.isFile();
                }
            });

            for (File f : files) {
                filesList.add(f);       
            }
        }