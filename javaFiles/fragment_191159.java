String filePath="file:///tmp/test.txt";
    public  void createFile(String path,Configuration conf) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(path), conf);
        fs.create(new Path(path));
        fs.close();
     }