public class StdoutReceiver {

    public static void logOnConsole(LoggingEvent event) {

        System.out.println("[" + event.getTimeStamp() + "]" + " ["
                + event.getThreadName() + "]" + " [" + event.getLoggerName()
                + "]" + " [" + event.getMessage() + "]");
    }

}