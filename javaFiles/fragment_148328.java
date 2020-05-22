void delete(File f) throws IOException {
    if (f.isDirectory()) {
        for (File c : f.listFiles()) {
            delete(c);
        }
    } else if (f.getAbsolutePath().endsWith("FIR")) {
        if (!f.delete()) {
            new FileNotFoundException("Failed to delete file: " + f);
        }
    }
}