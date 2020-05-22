String baseDirectory = "{whatever}";
String workDirectory = "workDirectory" + counter;
Path workPath = FileSystems.getDefault().getPath(baseDirectory, workDirectory);
Files.createDirectory(workPath);
Path lockFile = workPath.resolve("LOCKFILE");
Files.createFile(lockFile);
// Write the contents of the directory.
// [...]
Files.delete(lockFile);