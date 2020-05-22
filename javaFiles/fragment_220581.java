// check if the path exists
if (Files.exists(filePath)) {
    // check if the path points to a regular file (not a directory or symbolic link)
    if (Files.isRegularFile(filePath)) {
        System.out.println(filePath.toAbsolutePath().toString() 
                + " exists and is a regular file");
    } else {
        System.out.println(filePath.toAbsolutePath().toString() 
                + " exists, but is not a regular file");
    }
} else {
    System.out.println(filePath.toAbsolutePath().toString()
            + " does not exist");
}