import java.util.Scanner;

public class DriverSort {

    public static void main(String[] args) {

        Scanner scan =new Scanner(System.in);

        // this makes more sense to put this at the start of the program
        int choice;  // variable which says which sorting algorithm to use
        System.out.println("1-Insertion sort\n"
                +"2-Selection sort\n"
                + "3-Bubble sort\n"
                + "0-quit\n");
        choice = scan.nextInt();

        if (choice != 0) { // a simple if else statement will do just fine
            // must prompt user for the "input first"
            System.out.println("Enter the length vector to be modified: ");
            int size = scan.nextInt();
            // now actually get the vector
            int input[] = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.println("Enter next array element: ");
                input[i] = scan.nextInt();
            }

            System.out.println("\nBefore Sorting: ");
            System.out.println(input); // use the builtin functionality
            // sort the array
            int[] output = insertionSort(input);
            System.out.println("\nAfter Sorting: ");
            System.out.println(output);
        } else { 
            System.out.println("Goodbye!");
            System.exit(0);
        }  
    }

    // returns a sorted list (add more detail here)
    // add a new input that tells what sort of sorting to do
    public static int[] insertionSort(int[] input) {

        for (int i = 1; i < input.length; i++) {
            int valueToSort = input[i];
            int j = i;
            while (j > 0 && input[j - 1] > valueToSort) {
                input[j] = input[j - 1];
                j--;
            }//end while loop.
            // insert the element
            input[j] = valueToSort;
        }//end for loop    
        return input;
    } 
}