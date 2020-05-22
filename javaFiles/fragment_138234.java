public String setOutput(String name, File file) {
    File[] list = file.listFiles();
    if (list != null) {
        for (File fil : list) {
            String path = null;
            if (fil.isDirectory()) {
                path = setOutput(name, fil);
                if (path != null) {
                    return path;
                }
            } else if (fil.getName().contains(name)) {
                path =fil.getAbsolutePath();
                if (path != null) {
                    return path;
                }
            }
        }
    }
    return null; // nothing found
}