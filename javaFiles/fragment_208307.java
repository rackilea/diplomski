public static void main(String[] args) {
  String foo = null;
  String bar = null;
  String baz = "foo: " + foo + "; bar: " + bar;

  foo = "FOO";
  bar = "BAR";

  // change baz with new data
  baz = "foo: " + foo + "; bar: " + bar;

  System.out.println(baz);  // now this works!
}