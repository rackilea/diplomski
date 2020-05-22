@Override
public String format(LogRecord record)
{
    StringBuilder builder = new StringBuilder();

    Level level = record.getLevel();
    if(level == Level.INFO) {
      builder.append(ANSI_GREEN);
    } else if(level == Level.WARNING) {
      builder.append(ANSI_YELLOW);
    } else if(level == Level.SEVERE) {
      builder.append(ANSI_RED);
    } else {
      builder.append(ANSI_WHITE);
    }

    builder.append("[");
    builder.append(calcDate(record.getMillis()));
    builder.append("]");

    ...

}