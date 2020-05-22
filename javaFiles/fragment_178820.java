public static void main(String[] args) {
    // Make an anonymous instance of A
    final A first = new A() {
        private final int i = 10;

        void foo() {
            System.out.println(i);
        }
    };

    // Make another anonymous instance of A
    final A second = new A() {
        private final String message = "Listen!";

        void foo() {
            System.out.println("Hey!");
            System.out.println(message);
        }
    };

    // They do their own unique things
    first.foo();
    second.foo();

    // Both have A as a super-type
    System.out.println(first instanceof A);
    System.out.println(second instanceof A);

    // But first and second are *not* A and therefore not the same class!
    final boolean isSameClass = first.getClass().equals(second.getClass());
    System.out.println(isSameClass);
  }

  static abstract class A {
     abstract void foo();
  }