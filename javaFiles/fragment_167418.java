class Foo {

  int someField;
  String anotherField;

  public Foo(byte[] bytes) {
    someField = someFieldFromBytes(bytes);
    anotherField = anotherFieldFromBytes(bytes);
    etc.
 }
}