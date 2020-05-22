import java.util.Arrays;

public class Practice {

   static int[] oddNumbers(int minimum, int maximum) {

     int x = 0;

     for(int i = minimum; i <= maximum; i++){   //
        if(i % 2 != 0){                         ////
           ++x;                                 ////// Find the element count
        }                                       ////
     }                                          //

     int[] arr = new int[x]; // Construct array with the length of the element count
     x = 0; // Reset X (Just to avoid creating a new control variable)    

     for(int i = minimum; i <= maximum; i++){
         if(i % 2 != 0){
             arr[x] = i;
             ++x;
         }
      }

     return arr;
   }

   public static void main(String[] args) {
     int min = 3, max = 9;
     System.out.println(Arrays.toString(oddNumbers(min, max)));
   } 
}