private static List<SVNLogEntry> logEntryList;

    /*
     * Gets the Subversion log records for the directory
     */
    LogHandler handler = new LogHandler();
    String[] paths = { directory };
    try {
        repository.log(paths, latestRevision, 1L, false, true, handler);
    } catch (SVNException svne) {
        if (svne.getMessage().contains("not found")) {
            logEntryList = new ArrayList<SVNLogEntry>();
        } else {
            CobolSupportLog.logError(
                    "Error while fetching the repository history: "
                            + svne.getMessage(), svne);
            return false;
        }
    }

    logEntryList = handler.getLogEntries();