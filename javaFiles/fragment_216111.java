FileSystem fs = Jimfs.newFileSystem(Configuration.unix());
// now get path in the new FileSystem
Path data = fs.getPath("/virtual");    
// create a directory in the new FileSystem
Path dir = Files.createDirectory(data);
// create a file in the default FileSystem 
// with a parent that was never created there
Path file = Files.createFile(Paths.get(dir + "/abc.txt")); // throws NoSuchFileException