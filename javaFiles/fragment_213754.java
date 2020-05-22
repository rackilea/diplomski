message OneMessage {
  enum Type { FOO = 1; BAR = 2; BAZ = 3; }

  // Identifies which field is filled in.
  required Type type = 1;

  // One of the following will be filled in.
  optional Foo foo = 2;
  optional Bar bar = 3;
  optional Baz baz = 4;
}