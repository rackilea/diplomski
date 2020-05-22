class UtilClass { //util classes are bad don't do it
    private final FileSystem fileSystem;

    public UtilClass(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }


    public void createDirectories(final Path root, final Scaffolding scaffolding) throws FileAlreadyExistsException {
        if (fileSystem.exists(root)) {
            throw new FileAlreadyExistsException("Root directory " + root.toString() + " already exists.");
        } else {
            fileSystem.createDirectories(root);
            // Create directories from the scaffolding object
    }




interface FileSystem {

    boolean exists(Path path);

    void createDirectories(Path path);
}