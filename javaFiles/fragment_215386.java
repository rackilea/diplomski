public void close() {
    if (appendable instanceof Closeable) {
      try {
    ((Closeable) appendable).close();
      } catch (IOException e) {
    throw new JsonException(e);
      }
    }

    if (!(stack.getFirst() instanceof Empty)) {
      throw new JsonException("Attempting to close incomplete json stream");
    }
  }