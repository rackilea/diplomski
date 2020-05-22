public class SomeClass {
    private static int sum= 0;

    public void increaseSum() {
       synchronized (SomeClass .class) {
       sum++;
     }
   }
 }