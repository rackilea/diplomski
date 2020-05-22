import java.util.*;

public class ArrayWith10Numbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] myArray = new int[10];

        System.out.print("Enter " + myArray.length + " values: ");

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = input.nextInt();
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < myArray.length; i++) {
            if (!set.contains(myArray[i])) {
                System.out.println("myArray[" + i + "] is: " + myArray[i]);
                set.add(myArray[i]);
            }
        }
    }
}