String pattern = "filename*.tr"
try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir, pattern)) {
    //iterate over all matching files
    List<Path> paths = new ArrayList<>();
    for (Path path : ds) {
        paths.add(path);
    }
    if (paths.isEmpty()) {
        //no file found
    } else if (paths.size() == 1) {
        //found one result
        Path result = paths.get(0) //now do whatever
    } else {
        //more than one match - probably an error in your case?
    }
}