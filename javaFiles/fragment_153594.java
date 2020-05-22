public boolean isAck() {
  try {
    return acknowledged;
  } finally {
    setAck(false);
  }
}