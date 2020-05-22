package protobuf_unittest_import;

option java_package = "com.google.protobuf.nano";
// Explicit outer classname to suppress legacy info.
option java_outer_classname = "UnittestSimpleNano";

message SimpleMessageNano {
  message NestedMessage {
    optional int32 bb = 1;
  }

  enum NestedEnum {
    FOO = 1;
    BAR = 2;
    BAZ = 3;
  }

  optional int32 d = 1 [default = 123];
  optional NestedMessage nested_msg = 2;
  optional NestedEnum default_nested_enum = 3 [default = BAZ];
}