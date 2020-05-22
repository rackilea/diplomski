//This is where I query SVN server
if (entryPath.getType() != SVNLogEntryPath.TYPE_ADDED) {
    LogEntryPreviousRevFinder handler = new LogEntryPreviousRevFinder(workingFileName.substring(interestingPath.length()), thisRevision);

    //Start checking for previous modified revision for this file in the previous 3 revision.
    //If not found try for previous 5 and then 7. If not found till then, put in a warning and continue.
    //This is necessary because in SVN a branch operation is performed at the folder level and not file 
    //hence we need to go further back and find out the revision than was last modified.
    for (int i = 3; i <= 7; i+=2) {
        repository.log(new String[] {workingFileName}, thisRevision, 0l, true, false, i, handler);
        if (handler.isSuccess()) {
            prevPath = handler.getPreviousPath();
            prevRevision = handler.getPreviousRevision();
            break;
        } else {
            continue;
        }
    }

    if (!handler.isSuccess()) {
        log.warn("Failed to find previous revision for file: " + workingFileName 
                + " Will contine considering this one as added in this revision");
    }
} else {
    //Files with SVNLogEntryPath.TYPE_ADDED are either added in this revision
    //or are copied or renamed from an existing file. If later, we need to identify the Copy from path
    //as that will be the file which will be used for calculating relative metrics and later Flux values
    if (entryPath.getCopyPath() != null && entryPath.getCopyPath().trim().length() > 0) {
        prevPath = entryPath.getCopyPath();
        prevRevision = entryPath.getCopyRevision();
    } else {
        log.debug("File: " + workingFileName + " added in this revision");
    }
}