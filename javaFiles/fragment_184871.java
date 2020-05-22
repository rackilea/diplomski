final class Thing {

  static final Set allThings = new HashSet();

  private Thing() {
      allThings.add(this);
  } // control instances within class

  static final Thing instance0 = new Thing();
  static final Thing instance1 = new Thing();
}