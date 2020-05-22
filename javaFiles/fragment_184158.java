public class Test {
  public void test(Object obj) {
    if (obj instanceof Horse) {
      Horse c = (Horse) obj;
      noise(c);
    }
    if (obj instanceof Cow) {
      Cow c = (Cow) obj;
      noise(c);
    }
  }

  public void noise(Horse h) {
    System.out.println("Neigh");
  }

  public void noise(Cow c) {
    System.out.println("Moo");
  }

  public static void main(String[] args) {
    Object o1 = new Horse();
    Object o2 = new Cow();
    Test tester = new Test();
    tester.test(o1);
    tester.test(o2);
  }
}

class Horse {}

class Cow {}