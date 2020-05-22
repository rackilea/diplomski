public String packagePathToAbsolutePath(String packageName, String filename) {
    String absolutePath = "File not found";
    URL root = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));
    File[] files = new File(root.getFile()).listFiles();
    for (File file : files) {
        if (file.getName().equals(filename)) {
            absolutePath = file.getName();
            return absolutePath;
        }
    }
    return absolutePath;
}