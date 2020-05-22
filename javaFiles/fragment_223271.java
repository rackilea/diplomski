Foo actual = new Foo("foo");      // 1
                                  // 2
Foo formal = actual;              // 3
    formal.set("bar");            // 4
                                  // 5
actual.get(); // returns "bar"    // 6