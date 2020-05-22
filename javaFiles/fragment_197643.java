public ExceptionInterface(Throwable throwable) {
  this(SentryException.extractExceptionQueue(throwable));
}

public ExceptionInterface(Deque<SentryException> exceptions) {
  this.exceptions = exceptions;
}