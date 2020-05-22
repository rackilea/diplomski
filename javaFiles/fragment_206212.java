import java.util.Scanner;

public class ArraySort {
private static Object sc;    
private static Scanner keyboardScanner = new Scanner(System.in);

// creates question and int for user input
/**
 *
 */
public void fillArray(int[] array) {

    // creates for loop for repeating question based on array size 
    for (int i=0; i<array.length; i++) {
        System.out.println("Enter value for element " + i + ": ");
        array[i] = keyboardScanner.nextInt();
    }
}

// prints i in the for loop
public void printArray(String msg, int[] argsArray) {
    System.out.println(msg);
    for (int i=0; i<argsArray.length; i++) {
        System.out.println(argsArray[i]);
    }
}

//  defines method
public void sortArray(int[] array) {
    // sets up to output in ascending order
    for (int i=0; i<array.length; i++) {
        for (int j=i+1; j<array.length; j++) {
            if (array[i] > array[j]) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }

}

// main output and visual layout
public static void main(String[] args) {

    System.out.println("Enter the size of the array (3 to 10): ");
    int n = keyboardScanner.nextInt();

    int[] array = new int[n];

    ArraySort arraySort = new ArraySort();
    arraySort.fillArray(array);

    System.out.println();
    //I still get an error saying " cannot find symbol"
    arraySort.printArray("The unsorted values... ", array);
    //same here
    arraySort.sortArray(array);

    System.out.println();
    //and here
    arraySort.printArray("The sorted values... ", array);


    // Keep console window alive until 'enter' pressed (if needed).
    System.out.println();
    System.out.println("Done - press enter key to end program");

}
}