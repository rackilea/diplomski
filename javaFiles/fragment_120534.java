class AnonClass$1 extends AnonClass {
  final AnonClass enclosed;

  AnonClass$1(AnonClass enclosed, int x) {
    super(x);
    System.out.println(super.x);
    System.out.println(enclosed.x);
    this.enclosed = enclosed;
  }
}