public final class RealSource implements TimeSource {

  public long currentTimeMillis() {
    return System.currentTimeMillis();
  }

}