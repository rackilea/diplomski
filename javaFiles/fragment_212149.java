public String readLineWithTimeout(Process process, long timeout) throws IOException, TimeoutException {
  BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
  BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
  boolean finished = false;
  long startTime = 0;
  while (!finished) {
    if (output.ready()) {
      return output.readLine();
    } else if (error.ready()) {
      error.readLine();
    } else {
      try {
        process.exitValue();
        return null;
      } catch (IllegalThreadStateException ex) {
        //Expected behaviour
      }
    }
    if (startTime == 0) {
      startTime = System.currentTimeMills();
    } else if (System.currentTimeMillis() > startTime + timeout) {
      throw new TimeoutException();
    }
  }
}