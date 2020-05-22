message Foo { extensions 1000 to max; }
message Bar {
  extend Foo {
    optional int32 ext1 = 1234;
  }
}
extend Foo {
    optional int32 ext2 = 2345;
}