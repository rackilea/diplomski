public class LogEventContaining implements ArgumentMatcher<LogEvent> {
  private final String searchText;

  public LogEventContaining(String searchText) {
    this.searchText = searchText;
  }

  @Override public boolean matches(LogEvent logEvent) {
    // You could also use your Hamcrest matcher here.
    return logEvent.getMessage().indexOf(searchText) >= 0;
  }

  @Override public String toString() {
    return String.format("log message containing '%s'", searchText);
  }
}

// Per Mockito/Hamcrest style. This could go anywhere.
public static ArgumentMatcher<LogEvent> isALogEventContaining(String searchText) {
  return new LogEventContaining(searchText);
}