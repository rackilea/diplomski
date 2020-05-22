class MyLineMapper implements LineMapper<Object> {
  LineMapper<?> delegate;

  Object mapLine(String line, int lineNumber) {
    if(line is header) {
      return new LineToSkip(line, lineNumber);
    }
    return delegate.mapLine(line, lineNumber);
  }
}