public void setTimestamp(long value) {
  if(log.idDebugEnabled) {
    log.debug("Setting the value to " + value + ". Old value is " + this.timestamp);
    log.debug("Thread is " + Thread.currentThread().getName());
    log.debug("Stacktrace is", new Throwable()); // we could also iterate on Thread.currentThread().getStackTrace()
  }
  // check for bad value
  if(value & 0xffffffff00000000L == 0L) {
    log.warn("Danger Will Robinson", new IlegalValueException());
  }
  this.timestamp = value;
}