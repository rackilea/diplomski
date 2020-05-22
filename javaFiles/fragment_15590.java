synchronized (temp) {
  try {
    temp.wait();
  } catch (InterruptedException ie) {
    // handle this situation: something interrupted your thread before input was finished
  }
}