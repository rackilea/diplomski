import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DynamicArray {
  public static void main(String[] args) {

    System.out.println("Enter the limit of array :");
    Scanner s = new Scanner(System.in);
    int limit = s.nextInt();
    int[] array1 = new int[limit];//{12,23, -22, 0, 43,545, -4, -55,43, 12,0, -999, -87

    System.out.println("Enter the numbers");
    for (int i = 0; i < limit; i++) {
      array1[i] = s.nextInt();
    }
    List<Integer> arrayPlus = new ArrayList<>();
    List<Integer> arrayMinus = new ArrayList<>();


    for (int i = 0; i < limit; i++) {
      if (array1[i] >= 0) {
        arrayPlus.add(array1[i]);
      } else {
        arrayMinus.add(array1[i]);
      }
    }
    System.out.println("Positive array numbers");
    for (int i = 0; i < arrayPlus.size(); i++) {
      System.out.println(arrayPlus.get(i));
    }
    System.out.println("");

    System.out.println("Negative array numbers");
    for (int i = 0; i < arrayMinus.size(); i++) {
      System.out.println(arrayMinus.get(i));
    }
  }
}