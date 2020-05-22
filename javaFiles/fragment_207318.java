class Interpolator <T extends Interpolatable> {
  private final T target;

  Interpolator (T target) {
    this.target = target;
    int dim = target.getDimension();
  }
  void doSomething (double d) {
    Iterator <? extends Interpolatable> it = target.getIterator(d);
    Interpolatable t = it.next();
    …
  }
}