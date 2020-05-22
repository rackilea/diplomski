public final class Elements {
  private static enum ElementPredicate implements Predicate<Element> {
    SPECIAL {
      @Override public boolean apply(Element e) { return e.special; }
    }
  }

  public static Predicate<Element> isSpecial() {
    return ElementPredicate.SPECIAL;
  }

  private Elements() {}
}