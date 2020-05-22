try {
    DistributedFileSystem dfs = new DistributedFileSystem();
    Path path = new Path("/path/to/hadoop/file");
    FileSystem fs = path.getFileSystem(conf);
    dfs.initialize(fs.getUri(),conf);

    if (dfs.exists(path) && !dfs.isFileClosed(path)) {
        System.out.println("File " + path +" already opened in write mode");
    }
} catch (IOException e) {
    e.printStackTrace();
}