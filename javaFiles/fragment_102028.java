class YourClass {
  private final Factory factory;

  public YourClass() {
     this(Factory.getInstance(); }

  YourClass(Factory theFactory) {
     this.factory = theFactory;
  ...