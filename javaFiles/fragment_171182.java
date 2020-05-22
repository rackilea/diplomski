public class run {
  public static void main(String argv[]) {
    System.loadLibrary("test");
    DblVec dv = new DblVec(100);
    for (int i = 0; i < 100; ++i) {
      dv.set(i,(double)i);
    }
    FooVec fv = new FooVec(1);
    fv.set(0, new foo());
    for (double d: dv) {
      System.out.println(d);
    }
  }
}