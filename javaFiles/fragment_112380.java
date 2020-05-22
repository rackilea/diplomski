class Foo {
  final int bar; // is 0
  Foo() { }
}

class Foo {
  final int bar; // is 2
  Foo() { 
    bar = 1;
    bar = 2;
  }
}

class Foo {
  final int bar; // is 2
  Foo() { 
    this(null);
    bar = 2;
  }
  Foo(Void v) {
    bar = 1;
  }
}