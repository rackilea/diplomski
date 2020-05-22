public class MyCustomLogFormatter extends TextLogFormatter{
    private static DateTimeFormat timeFormat = DateTimeFormat.getFormat("HH:mm:ss.SSS");
    public MyCustomLogFormatter() {
        super(true);
    }

    @Override
    public String format(LogRecord event) {
        StringBuilder message = new StringBuilder();
        message.append(getRecordInfo(event, " "));
        message.append(event.getMessage());
        message.append(getStackTraceAsString(event.getThrown(), "\n", "\t"));
        return message.toString();
    }
    @Override
    protected String getRecordInfo(LogRecord event, String newline) {
        Date date = new Date(event.getMillis());
        StringBuilder s = new StringBuilder();
        s.append(timeFormat.format(date));
        s.append(" GWT ");
        s.append(event.getLevel().getName());
        String loggerName = event.getLoggerName();
        String[] split = loggerName.split("\\.");
        s.append(" ");
        s.append(split[split.length-1]);
        s.append(newline);
        s.append(": ");
        return s.toString();
      }
}