Foo actual = new Foo("foo");      // 1
                                  // 2
Foo formal = actual;              // 3
    formal = new Foo("bar");      // 4
                                  // 5
actual.get(); // returns "foo"    // 6