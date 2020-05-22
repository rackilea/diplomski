class Test
  extends TestSuper
{
  final int ti1;
  final int ti2 = counter ++;
  { ti1 = counter ++; }
  static final int ts1;
  static final int ts2 = counter ++;
  static { ts1 = counter ++; }

  public static void main(String[] argv) {
    Test test1 = new Test();
    printTest(test1);
    Test test2 = new Test();
    printTest(test2);
  }
  private static void printTest(Test test) {
    System.out.print("ss2 = " + test.ss2);
    System.out.print(", ss1 = " + test.ss1);
    System.out.print(", ts2 = " + test.ts2);
    System.out.println(", ts1 = " + test.ts1);
    System.out.print("si2 = " + test.si2);
    System.out.print(", si1 = " + test.si1);
    System.out.print(", ti2 = " + test.ti2);
    System.out.println(", ti1 = " + test.ti1);
    System.out.println("counter = " + test.counter);
  }
}

class TestSuper
{
  static int counter = 0;
  final int si1;
  final int si2 = counter ++;
  { si1 = counter ++; }
  static final int ss1;
  static final int ss2 = counter ++;
  static { ss1 = counter ++; }
}