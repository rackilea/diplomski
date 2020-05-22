private static class Element implements Comparable<Element> {
  // raw Comparable allows you to call compareTo
  private final Comparable comparable;

  Element(Comparable comparable) {
    this.comparable = comparable;
  }

  @Override @SuppressWarnings("unchecked")
  public int compareTo(Element o) {
    Comparable other = o.comparable;
    if(comparable.getClass().isInstance(other)) {
      return comparable.compareTo(other);
    }

    return comparable.getClass().getName().compareTo(other.getClass().getName());
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Element && comparable.equals(((Element) obj).comparable);
  }

  @Override
  public int hashCode() {
    return comparable.hashCode();
  }

  @Override
  public String toString() {
    return comparable.toString();
  }
}