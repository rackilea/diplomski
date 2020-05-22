syntax = "proto2";

package termin4t0r;
option java_package = "com.example.termin4t0r";

// Proto for java.util.regex.Pattern
message RegexPatternProto {
  // See Pattern.pattern()
  optional string pattern = 1;
  // See Pattern.flags()
  optional int64 flags = 2;
}