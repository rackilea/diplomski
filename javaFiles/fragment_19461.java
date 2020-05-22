class Foo {
    public final String i = "Winter";
}
void main() {
  Foo a = new Foo();
  a.i = "Summer"; // Error: final field cannot be modified.
}