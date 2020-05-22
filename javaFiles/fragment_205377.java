import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.*;
import java.util.Arrays;

public class MyClass {
    public static void main(String[] args) {
        int[] arrayToSort = new int[800];
        IntStream.range(0,arrayToSort.length).forEach(i -> arrayToSort[i] = ThreadLocalRandom.current().nextInt(-10000, 10000 + 1) );
        bubbleSort(arrayToSort);
    }
    public static void bubbleSort(int[] arrayToSort)
    {
      int comps=0;
      int swaps=0;


      for(int i = 0; i < arrayToSort.length-1; i++) 
      {
         for(int j = 0; j < arrayToSort.length-1; j++)
         {
            comps++;
            if(arrayToSort[j] > arrayToSort[j+1])
            {
               swaps++;
               int temp = arrayToSort[j];
               arrayToSort[j] = arrayToSort[j+1];
               arrayToSort[j+1] = temp;  
            }   
         }   

      }

        System.out.println("\nComparisions: " + comps + " swaps: " + swaps);
        IntStream.range(0,arrayToSort.length).forEach(i -> {
            String outStr = arrayToSort[i] + " , ";
            if(i % 100 == 0)
                System.out.println(outStr);
            else
                System.out.print(outStr);
        });
    }
}