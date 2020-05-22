class Foo {
  { new Bar(); }
  class Bar() {
    private Bar() { }
  }
}