--- a/utils bench/src/main/java/org/kirmit/utils/unsafe/concurrency/UnsafeCASCounter.java       
+++ b/utils bench/src/main/java/org/kirmit/utils/unsafe/concurrency/UnsafeCASCounter.java       
@@ -20,6 +21,7 @@ public class UnsafeCASCounter implements Counter {
         long before = counter;
         while (!unsafe.compareAndSwapLong(this, offset, before, before + 1L)) {
             before = counter;
+            Blackhole.consumeCPU(1000);
         }
     }