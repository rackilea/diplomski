public List<File> folderSearchBT(File src, String folder)
        throws FileNotFoundException {

    List<File> result = new ArrayList<File>();

    File[] filesAndDirs = src.listFiles();
    List<File> filesDirs = Arrays.asList(filesAndDirs);
    for (File file : filesDirs) {
        result.add(file); // always add, even if directory
        if (!file.isFile()) {
            List<File> deeperList = folderSearchBT(file, folder);
            result.addAll(deeperList);
        }
    }
    return result;
}