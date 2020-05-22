public abstract class MyAbstractClass {
  @Override public final int hashCode() { return hashCodeImpl(); }
  @Override public final boolean equals(Object o) { return equalsImpl(o); }

  protected abstract int hashCodeImpl();
  protected abstract boolean equalsImpl(Object o);
}