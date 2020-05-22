String pathToFile = "/tmp/foo.txt";
try {
    Files.createFile(FileSystems.getDefault().getPath(pathToFile + ".claimed"));
    processFile(pathToFile);
} catch (FileAlreadyExistsException e) {
    // some other app has already claimed "filename"
}