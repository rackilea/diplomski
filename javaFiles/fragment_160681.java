public final class FakeSource implements TimeSource {

  public long currentTimeMillis() {
    return //...whatever you want
  }

}