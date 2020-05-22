public class MyHandler extends Handler {

    @Override
    public void close() throws SecurityException {
        // housekeeping before handler close
    }

    @Override
    public void flush() {
        // not really needed as data is processed without any sort of buffering
    }

    @Override
    public void publish(LogRecord record) {
        System.out.println("Foobar " + record.getMessage().toUpperCase());
    }

}