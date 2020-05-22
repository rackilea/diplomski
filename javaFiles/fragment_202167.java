public class SyncRecordLogging  implements LittleLogging{

    private final RecordLogging _log;

    public SyncRecordLogging() {
        _log = new RecordLogging();
    }

    public synchronized void log(String log) {
        _log.log(log);
    }

    public synchronized void logPart(String log) {
        _log.logPart(log);
    }

    public synchronized LinkedList<String> getResults() {
        // returning copy to avoid 'leaking' the enderlying reference
        return new LinkedList(_log.getResults());
    }
}