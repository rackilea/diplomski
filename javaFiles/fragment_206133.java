public static File createTempFile(String prefix, String suffix, File directory)
        throws IOException {
    // Force a prefix null check first
    if (prefix.length() < 3) {
        throw new IllegalArgumentException("prefix must be at least 3 characters");
    }
    if (suffix == null) {
        suffix = ".tmp";
    }
    File tmpDirFile = directory;
    if (tmpDirFile == null) {
        String tmpDir = System.getProperty("java.io.tmpdir", ".");
        tmpDirFile = new File(tmpDir);
    }
    File result;
    do {
        result = new File(tmpDirFile, prefix + tempFileRandom.nextInt() + suffix);
    } while (!result.createNewFile());
    return result;
}