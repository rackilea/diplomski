private Path[] getVerifiedPaths()
{
    ArrayList<Path> verifiedFilePaths= new ArrayList<>();
    for(Path filepath : fileList)
        verifiedFilePaths.add(filepath);
    return verifiedFilePaths.toArray(new Path[0]);
}

Path[] filePaths = getVerifiedPaths();
    for(Path filePath : filePaths) { ...rename...}