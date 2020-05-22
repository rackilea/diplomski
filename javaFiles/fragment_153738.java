File f = new File("/data/data/package.name/");
File[] files = f.listFiles();
for (File inFile : files) {
    if (inFile.isDirectory()) {
        // is directory; recurse?
    } else {
        doLogicFor(inFile);
    }
}