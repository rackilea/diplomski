/**
 * Returns files in the {@code filesInDir} that are not included in the {@code myFiles} list.
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
    Set<String> myFileNames = recordFileNames(myFiles);
    for (File fileInDirectory : filesInDir) {
        if (! myFileNames.contains(fileInDirectory.getName().toLowerCase())) {
            filesNotInMyList.add(fileInDirectory);
        }
    }

    return filesNotInMyList;
}

/**
 * Creates a set containing the file names of all the records in the given list of records.
 * 
 * @param myFiles my list of files
 * @return a set containing the file names of all the records in the given list of records
 */
Set<String> recordFileNames(List<Record> myFiles) {
    Set<String> recordFileNames = new HashSet<>();
    for (Record file : myFiles) {
        recordFileNames.add(file.getDetails().getName().toLowerCase());
    }
    return recordFileNames;
}