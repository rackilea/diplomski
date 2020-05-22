enum Digit { ZERO, ONE, TWO, THREE, FOUR, FIVE }

public class Foo {
  Digit[] array = new Digit[1];

  Foo() {
    array[0] = Digit.ZERO;
  }

  Foo(Foo old, Digit num) {
    this.array = old.array;
    array[0] = num;
  }

  public String toString() {
    return array[0].toString();
  }

  public static void main(String[] args) {
    Foo f = new Foo();
    System.out.println(f);
    Foo other = new Foo(f, Digit.ONE);
    System.out.println(f);
  }
}