/**
 * Returns a set of files in the {@code filesInDir} that are not included in the {@code myFiles} list.
 * 
 * <p>
 * Does a case insensitive comparison of file names to confirm presence.
 * 
 * @param filesInDir the files in a given directory
 * @param myFiles my list of files
 * @return files in the {@code filesInDir} that are not included in the {@code myFiles} list
 */
Set<File> filesNotIncludedInMyList(File[] filesInDir, List<Record> myFiles) {
    Set<File> filesNotInMyList = new HashSet<>();
    for (File fileInDirectory : filesInDir) {
        boolean fileInDirectoryIncludedInMyList = false;
        for (Record myFile : myFiles) {
            if (fileInDirectory.getName().equalsIgnoreCase(myFile.getDetails().getName())) {
                fileInDirectoryIncludedInMyList = true;
            }
        }
        if (! fileInDirectoryIncludedInMyList) {
            filesNotInMyList.add(fileInDirectory);
        }
    }

    return filesNotInMyList;
}