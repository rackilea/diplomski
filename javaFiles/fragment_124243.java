//Search code
for (File fileSearched : allFiles) {
    BasicFileAttributes attrs = Files.readAttributes(Paths.get(fileSearched.getAbsolutePath()), BasicFileAttributes.class);      
    Calendar creationTime = Calendar.getInstance();
    creationTime.setTimeInMillis(attrs.creationTime().toMillis());

    Calendar modifiedTime = Calendar.getInstance();
    modifiedTime.setTimeInMillis(attrs.lastModifiedTime().toMillis());

    if(creationTime.after(filter) || modifiedTime.after(filter)){
        filesFound.add(fileSearched);
    }
}