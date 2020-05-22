public static File searchFile(File currentFile) {
    if (!currentFile.isDirectory()) {
        throw new InvalidArgumentException("Starting point must be a directory");
    }
    for (File file : currentFile.listFiles()) {
        if (file.isDirectory()) {
            File result = searchFile(file);
            if (result != null) {
                return result;
            }
        } else if (file.getName().toLowerCase().endsWith(".sh")) {
            return file;
        }
    }
    // Not found anything: return null to indicate failure (in this branch)
    return null;
}