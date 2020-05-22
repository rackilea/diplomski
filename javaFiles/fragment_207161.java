class Foo {
  public static void main(String args[]) {
    String s = null;
    s += "foo";
    System.out.println(s);  // prints "nullfoo"
  }
}