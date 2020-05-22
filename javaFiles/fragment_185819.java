catch (Exception e) {
  if (counter > 5) {
    throw new RetryLimitReachedException("Failed to do X, retried 5 times", e);
  }
....
}