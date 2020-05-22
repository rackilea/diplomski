public static File getTextFileInDirectory(String dirPath) {
    File dir = new File(dirPath);
    for (File f : dir.listFiles()) {
        if (f.isFile() && f.getName().endsWith(".txt")) {
            return f;
        }
    }
    return null;
}