import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class BubbleTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number to create array."+"\n");
        int z = scan.nextInt();
        int [] array = new int[z];
        // Randomly generating array elements

        for(int i =0; i<z; i++){
            array[i]=new Random().nextInt();
        }
      //  z = scan.nextInt();
        System.out.println("Unsorted:");
        System.out.println(Arrays.toString(array));


        //Bubble Sort
        for(int i = array.length-1; i>=0; i--)
        {
            for(int j=0; j<i; j++)
            {
                if(array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        System.out.println("sorted:");
        System.out.println(Arrays.toString(array));
    }

}