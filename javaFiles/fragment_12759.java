private void search(File directory) {
    if (directory.isDirectory()) {
        File[] javaFilesLs = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".java") || new File(dir.toPath().toString(), name).isDirectory();
            }
        });
        if (directory.canRead()) {
            assert javaFilesLs != null;
            for (File temp : javaFilesLs) {
                if (temp.isDirectory()) {
                    search(temp);
                } else {
                    fileList.add(temp.getAbsolutePath());
                }
            }
        }
    }
}