$ javac --patch-module java.logging=mdl-plarform/src/main/java \
      mdl-plarform/src/main/java/com/test/mdl/platform/Patch.java

mdl-plarform/src/main/java/module-info.java:1: error: module name com.test.mdl.plarform does not match expected name java.logging
module com.test.mdl.plarform {
^
error: cannot access module-info
  cannot resolve modules
2 errors