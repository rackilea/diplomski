import java.util.Scanner;
public class addArrays {
    public static void main (String[]args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the size of an array: ");
        int size = in.nextInt();
        System.out.println("Please enter numbers to populate array 1: ");
        int[] array1 = new int[size];
        for (int i = 0; i < size; i++) {
            array1[i] = in.nextInt();
        }
        System.out.println("Please enter numbers to populate array 2: ");
        int[] array2 = new int[size];
        for (int j = 0; j < size; j++) {
            array2[j] = in.nextInt();
        }
        System.out.println("Thank you! The result is: ");
        int[] arr3 = addArrays(array1, array2);
        for (int j = 0; j < size; j++) {
            System.out.println(arr3[j]);
        }
    }
    public static int[] addArrays(int[] arr1, int[] arr2) {
        int size = arr1.length;
        int[] array3 = new int[size];
        for (int k = 0; k < size; k++) {
            array3[k] = arr1[k] + arr2[k];
        }
        return array3;
    }
}