public static void main(String[] args) {
  String foo = null;
  String bar = null;
  String baz = "foo: " + foo + "; bar: " + bar;

  foo = "FOO";
  bar = "BAR";

  System.out.println(baz);
}