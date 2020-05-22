public class Test {
  public void test(Animal obj) {
    obj.noise();
  }

  public static void main(String[] args) {
    Animal o1 = new Horse();
    Animal o2 = new Cow();
    Test tester = new Test();
    tester.test(o1);
    tester.test(o2);
  }
}

interface Animal {
  void noise();
}

class Horse implements Animal {
  public void noise() {
    System.out.println("Neigh");
  }
}

class Cow implements Animal {
  public void noise() {
    System.out.println("Moo");
  }
}