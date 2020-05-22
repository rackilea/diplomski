import java.util.Scanner;
import java.util.Arrays;

public class Program {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int value=0;
        int[] values = {16,10,11,14,17};

        Arrays.sort(values);

        do {
            System.out.println("Enter a number:");
            value = input.nextInt();    
        } while(Arrays.binarySearch(values, value) < 0); 
    }
}