void executeWithRetries(int maxRetries) {
  Exception thrown = null;

  for (int retry = 0; retry < maxRetries; retry++) {
    try {
      callFunction();
      return;
    } catch (Exception e) {
      thrown = e;
      warn("callFunction failed. Retrying.." + retry);
    }
  }

  warn("reached max");
  thrown.printStackTrace();
}