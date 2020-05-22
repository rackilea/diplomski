String baseDirectory = "{whatever}";
String workDirectory = "workDirectory" + counter;
Path tempPath = FileSystems.getDefault().getPath(baseDirectory, ".temp_" + workDirectory);
Path workPath = FileSystems.getDefault().getPath(baseDirectory, workDirectory);
Files.createDirectory(tempPath);
// Write the contents of the directory.
// [...]
Files.move(tempPath, workPath, CopyOptions.ATOMIC_MOVE);