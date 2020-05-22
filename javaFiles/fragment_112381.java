class Foo {
  static final int bar; // is 0
  static { }
}


class Foo {
  static final int bar; // is 2
  static {
    bar = 1;
    bar = 2;
  }
}

class Foo {
  static final int bar; // is 2
  static {
    bar = 1;
    foobar(2);
  }
  static foobar(int i) {
    bar = i;
  }
}

Foo.foobar(3); // bar is 3