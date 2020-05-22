import java.util.Arrays;
import java.util.Random;

public class Assignment1 {

public static void main(String[] args){

private static Random rand = new Random();
int evenCount = 0;
int oddCount = 0;
int sum = 0;

//Declare an array to hold eight integers. 
int[] arrayWithEightInts = new int[8];

//Use a for loop to add eight random integers, all in the range from 50 to 100, inclusive, to this array. Duplicates are okay.

for (int x = 0; x < 8; x++){
        arrayWithEightInts [x] = rand.nextInt((100 - 50) + 1) + 50;
}

//Next, pass the array to a method that sorts the array and returns another array containing only the largest and smallest elements in the original array. 
int[] smallestLargest = sortArrayAndReturnSmallestLargest(arrayWithEightInts);

//Print these two values in main. 
System.out.println(“The lowest element is ” + smallestLargest[0];
System.out.println(“The highest element is ” + smallestLargest[1];

//Then use a foreach loop to display all elements of the sorted array on one line separated by a single space. This latter loop should also count the odd and even numbers in the array and determine the sum of all elements in the array.
System.out.println(“Here is the array”);
for(int item: arrayWithEightInts){
    sum = sum + item;
    System.out.print(item + “ ”);
    if(x % 2 == 0){
                evenCount++;
    } else {
                oddCount++;
    }
}
System.out.println();
System.out.println(“Evens: ” + evenCount + “, odds: “ + oddCount);
System.out.println(“Total: ” + sum);
}


public static int[] sortArrayAndReturnSmallestLargest(int[] randomEight){
    int[] smallestLargest = new int[2];
    Arrays.sort(randomEight);
    smallestLargest[0] = randomEight[0];
    smallestLargest[1] = randomEight[randomEight.size()-1];
    return smallestLargest;
}
}