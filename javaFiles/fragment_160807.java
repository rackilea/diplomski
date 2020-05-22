$  cat my.proto 
message header {
  required uint32 u1 = 1;
  required uint32 u2 = 2;
  optional uint32 u3 = 3 [default=0];
  optional bool   b1 = 4 [default=true];
  optional string s1 = 5;
  optional uint32 u4 = 6;
  optional uint32 u5 = 7;
  optional string s2 = 9;
  optional string s3   = 10; 
  optional uint32 u6 = 8;
}