import  java.util.ArrayList;
   import  java.util.Arrays;
   import  java.util.Collections;
/**
   <P>{@code java OrderIntListXmpl}</P>
 **/
public class OrderIntListXmpl  {
   public static final void main(String[] igno_red)  {
      int[] aiNums = new int[] {1, 11, 29, 12, 13, 19, 7, 2, 6, 16, 10, 15, 112, 18, 20, 3, 8, 5, 9, 14};

      System.out.println("Unsorted: " + Arrays.toString(aiNums));

      ArrayList<Integer> alNums = new ArrayList<Integer>(aiNums.length);
      for(int i : aiNums)  {
         alNums.add(i);
      }
      Collections.sort(alNums);

      System.out.println("Sorted: " + Arrays.toString(alNums.toArray()));

      int ixOf12 = Collections.<Integer>binarySearch(alNums, 12);

      System.out.println("Index of number 12: " + ixOf12);
   }
}