//ISVNLogEntryHandler implementation for identifying previous revision
private class LogEntryPreviousRevFinder implements ISVNLogEntryHandler {
    private String interestingFile;
    private String previousPath;
    private long thisRevision;
    private long previousRevision;
    private boolean isSuccess;

    public LogEntryPreviousRevFinder(String interestingFile, long revision) {
        this.interestingFile = interestingFile;
        this.thisRevision = revision;
        isSuccess = false;
    }

    @Override
    public void handleLogEntry(SVNLogEntry logEntry) throws SVNException {
        if (isSuccess)
            return;

        if (thisRevision == logEntry.getRevision())
            return;

        Set changedPathsSet = logEntry.getChangedPaths().keySet();
        for (Iterator changedPaths = changedPathsSet.iterator(); changedPaths.hasNext();) {
            SVNLogEntryPath entryPath = (SVNLogEntryPath) logEntry.getChangedPaths().get(changedPaths.next());
            String workingFileName = entryPath.getPath();

            if (workingFileName.endsWith(interestingFile)) {
                previousRevision = logEntry.getRevision();
                previousPath = workingFileName;
                isSuccess = true;
            }
        }
    }

    public long getPreviousRevision() {
        return previousRevision;
    }
    public String getPreviousPath() {
        return previousPath;
    }
    public boolean isSuccess() {
        return isSuccess;
    }
}