public class MyArray {
     private int[] myArray = new int[10000];
     private int index = -1;

     public void add(int obj) {
        index++;
        myArray[index] = obj;
     }

     public Integer removeLast() {
         if (index >= 0) {
             return myArray[index--];
         }
         return null;
     }

     public Integer get(int i) {
         if (i >= 0 && i < index) {
             return myArray[i];
         }
         return null;
     }
 }