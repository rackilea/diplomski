static class FirstException extends Exception { }
static class SecondException extends Exception { }

public void rethrowException(String exceptionName) throws Exception {
  try {
    if (exceptionName.equals("First")) {
      throw new FirstException();
    } else {
      throw new SecondException();
    }
  } catch (Exception e) {
    throw e;
  }
}