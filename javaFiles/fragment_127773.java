public Holder holder;
public void initialize() { holder = new Holder(42); }

publc class Holder {
  private int n;
  public Holder(int n) { this.n = n; }

  public void assertSanity() {
    if (n != n) {
      throw new AssertionError(”This statement is false”);
    }
  }
}

// Thread 1:             // Thread 2:
initialize();            if (holder != null) holder.assertSanity();