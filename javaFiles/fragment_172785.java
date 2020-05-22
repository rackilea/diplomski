class Wrapper<E> {

  private final E item;

  Wrapper(E item) {
    this.item = item;
  }

  E getItem() {
    return item;
  }

  public boolean equals(Object o) {
    if (!(o instanceof Wrapper)) {
      return false;
    }
    return getClass().equals(o.getClass());
  }

  public int hashCode() {
    return getClass().hashCode();
  }

}