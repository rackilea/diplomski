Index: http://svn.apache.org/repos/asf/tomcat/tc8.5.x/trunk/java/org/apache/tomcat/util/http/parser/HttpParser.java
===================================================================
--- java/org/apache/tomcat/util/http/parser/HttpParser.java (revision 1755813)
+++ java/org/apache/tomcat/util/http/parser/HttpParser.java (working copy)
@@ -62,7 +62,7 @@
     }

     public static String unquote(String input) {
-        if (input == null || input.length() < 2) {
+        if (input == null || input.length() < 2 || input.charAt(0) != '"') {
             return input;
         }