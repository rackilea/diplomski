File f = new File(path);
File[] files = f.listFiles();
for (File inFile : files) {
    if (inFile.isDirectory()) {
        // is directory
    }
}