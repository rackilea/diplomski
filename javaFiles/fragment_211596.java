class A {

  String x, y, z, a;

  /** Constructor. Protected. See static helpers for object creation */
  protected A(String x, String y, String z, String a) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.a = a;
  }

  /** Construct a new A with an x, y, and z */
  public static A fromXYZ(String x, String y, String z) {
    return new A(x, y, z, null);
  }

  /** Construct a new A with an a, y, and z */
  public static A fromAYZ(String a, String y, String z) {
    return new A(a, null, y, z);
  }
}