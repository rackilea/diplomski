--- a/utils bench/src/main/java/org/kirmit/utils/unsafe/concurrency/UnsafeCASCounter.java       
+++ b/utils bench/src/main/java/org/kirmit/utils/unsafe/concurrency/UnsafeCASCounter.java       
@@ -5,13 +5,13 @@ import sun.misc.Unsafe;

 public class UnsafeCASCounter implements Counter {
     private volatile long counter = 0;
-    private final Unsafe unsafe = UnsafeHelper.unsafe;
-    private long offset;
-    {
+    private static final Unsafe unsafe = UnsafeHelper.unsafe;
+    private static final long offset;
+    static {
         try {
             offset = unsafe.objectFieldOffset(UnsafeCASCounter.class.getDeclaredField("counter"));
         } catch (NoSuchFieldException e) {
-            e.printStackTrace();
+            throw new IllegalStateException("Whoops!");
         }
     }