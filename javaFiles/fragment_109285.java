public final class Thing implements Serializable {
  private static final long serialVersionUID = 1L;
  private static final Thing[] INSTANCES = new Thing[2];
  private static int NEXT_ORDINAL = 0;

  public static final Thing INSTANCE0 = new Thing(
      "whatever0");
  public static final Thing INSTANCE1 = new Thing(
      "whatever1");

  private transient final String someState;

  public String someMethod() {
    return someState;
  }

  private final int ordinal;

  private Thing(String someState) {
    this.someState = someState;
    ordinal = NEXT_ORDINAL++;
    INSTANCES[ordinal] = this;
  }

  private Object writeReplace() {
    return new ThingProxy(this);
  }

  private void readObject(ObjectInputStream stream)
      throws InvalidObjectException {
    throw new InvalidObjectException("Proxy required");
  }

  private static class ThingProxy implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int ordinal;

    private ThingProxy(Thing t) {
      ordinal = t.ordinal;
    }

    private Object readResolve()
        throws ObjectStreamException {
      return INSTANCES[ordinal];
    }

  }

}