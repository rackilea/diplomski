public class Foo implements Runnable {
     private volatile CustomArray<Integer> arr;
     private volatile Integer sum;

     public Foo(CustomArray<Integer> arr) {
         this.arr = arr;
     }

     @Override
     public void run() {
        synchronized(this.arr) {
            sum = arr.getSum();
        }
     }

     public Integer getValue() {
         synchronized(this.arr) {
             return sum;
         }
     }
 }