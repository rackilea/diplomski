public FileSystemFactory createFileSystemFactory(String bucketName) throws IOException, URISyntaxException {
    FileSystem fileSystem = FileSystems.newFileSystem(new URI("s3:///"), env, Thread.currentThread().getContextClassLoader());
    String bucketPath = fileSystem.getPath("/" + bucketName);

    return new VirtualFileSystemFactory(bucketPath);
}