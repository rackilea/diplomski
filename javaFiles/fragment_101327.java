message Foo { extensions 1000 to max; }
message Bar { ... }
extend Foo {
  optional Bar ext1 = 1234;
  optional Bar ext2 = 2345;
}