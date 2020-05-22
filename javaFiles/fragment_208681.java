public void rethrowException(String exceptionName)
throws FirstException, SecondException {
  try {
    // ...
  }
  catch (Exception e) {
    throw e;
  }
}