public class SomeClass{
      private static int sum = 0;
      private static final Object locker = new Object();

      public void increaseSum() {
           synchronized (locker) {
           sum++;
      }
    }
  }