--- mytest_types.cpp    2016-02-26 20:02:57.210652969 +0300
+++ mytest_types.cpp.old   2016-02-26 20:02:39.650652742 +0300 
@@ -80,13 +80,17 @@
apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
xfer += oprot->writeStructBegin("Value");

-  xfer += oprot->writeFieldBegin("i16_v", ::apache::thrift::protocol::T_I16, 1);
-  xfer += oprot->writeI16(this->i16_v);
-  xfer += oprot->writeFieldEnd();
+  if (this->__isset.i16_v) {
+    xfer += oprot->writeFieldBegin("i16_v", ::apache::thrift::protocol::T_I16, 1);
+    xfer += oprot->writeI16(this->i16_v);
+    xfer += oprot->writeFieldEnd();
+  }

-  xfer += oprot->writeFieldBegin("str_v", ::apache::thrift::protocol::T_STRING, 2);
-  xfer += oprot->writeString(this->str_v);
-  xfer += oprot->writeFieldEnd();
+  if (this->__isset.str_v) {
+    xfer += oprot->writeFieldBegin("str_v", ::apache::thrift::protocol::T_STRING, 2);
+    xfer += oprot->writeString(this->str_v);
+    xfer += oprot->writeFieldEnd();
+  }