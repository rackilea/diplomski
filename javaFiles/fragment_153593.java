public boolean isAck() {
  if (acknowledged) {
    setAck(false);
    return true;
  }
  return false;
}