public class LogHandler implements ISVNLogEntryHandler {

    protected static final int REVISION_LIMIT = 5;

    protected List<SVNLogEntry> logEntryList;

    public LogHandler() {
        logEntryList = new ArrayList<SVNLogEntry>();
    }

    public void handleLogEntry(SVNLogEntry logEntry) throws SVNException {
        logEntryList.add(logEntry); 
    }

    public List<SVNLogEntry> getLogEntries() {
        if (logEntryList.size() <= REVISION_LIMIT) {
            return logEntryList;
        } else {
            return logEntryList.subList(0, REVISION_LIMIT);
        }
    }

}