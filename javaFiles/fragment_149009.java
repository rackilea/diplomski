public class CcPurgeLogger extends Handler {

    private static volatile Handler common;
    private static long count;


    private static void create() throws IOException {
        synchronized (CcPurgeLogger.class) {
            if (common == null) {
               common = new FileHandler(); 
            }
            count++;
        }
    }

    public CcPurgeLogger() throws IOException {
        create();
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        String name = record.getLoggerName();
        return ("com.project.callcontrol.PurgeDeadCalls".equals(name)
                || "com.project.callcontrol.CCPurgeEvent".equals(name))
                && common.isLoggable(record);
    }

    @Override
    public void publish(LogRecord record) {
        common.publish(record);
    }

    @Override
    public void flush() {
        common.flush();
    }

    @Override
    public void close() throws SecurityException {
        synchronized (CcPurgeLogger.class) {
            if (common != null) {
                if (count == 1L) {
                    common.close();
                    common = null;
                }
                --count;
            }
        }
    }
}