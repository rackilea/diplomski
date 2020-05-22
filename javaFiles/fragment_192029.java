String destination = "directory1/directory2";
CloudFileDirectory rootDir = share.getRootDirectoryReference();
String[] destinationNameArray = destination.split("/");
CloudFileDirectory kidDir = rootDir;
for(String name: destinationNameArray) {
    kidDir = kidDir.getDirectoryReference(name);
    kidDir.createIfNotExists();
}