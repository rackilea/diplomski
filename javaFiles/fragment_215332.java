public class SomeClass {
   private Object mutex = new Object();
   public static synchronized void method1() {
      // static methods aquire the class level lock for SomeClass 
   }
   public synchronized void method2() {
      // aquire the lock associated with 'this' instance (of SomeClass)
   }
   public void method3() {
      synchronized (mutex) {
         // aquire the lock of the mutex object
      }
   }
}