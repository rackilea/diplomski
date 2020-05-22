public class OutConsoleHandler extends StreamHandler {

   public OutConsoleHandler() {
        super(System.out, new SimpleFormatter());
        //TODO: Read level,filter,encoding from LogManager.
   }

    @Override
    public void publish(LogRecord record) {
        super.publish(record);
        super.flush();
    }

    @Override
    public void close() {
        super.flush();
    }
}