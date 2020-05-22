class Pipe<E> {
  // ...
  public final E take() {
    try {
      read.acquire();
      return e;
    } finally {
      write.release();
    }
  }
}