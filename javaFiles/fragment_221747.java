public class Test {
  private final int m, n;

  public Test(int m, int n) {
    this.m = m;
    this.n = n;
  }

  public int hashCode() { return n * m; }

  public boolean equals(Object ob) {
    if (ob.getClass() != Test.class) return false;
    Test other = (Test)ob;
    return m == other.m;
  }
}