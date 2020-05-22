String source = "directory1/directory2/directory3/directory4";
String destination = "directory1/directory2";
String fileName = "1";
CloudFileDirectory sourceDir = rootDir.getDirectoryReference(source);
CloudFileDirectory destinationDir = rootDir.getDirectoryReference(destination);
CloudFile sourceFile = sourceDir.getFileReference(fileName);
CloudFile destinationFile = destinationDir.getFileReference(fileName);
destinationFile.startCopy(sourceFile);