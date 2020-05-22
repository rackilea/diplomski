import java.util.Scanner;

class DynamicArray {
  public static void main(String[] args) {
    int p=0,n=0;
    System.out.println("Enter the limit of array :");
    Scanner s = new Scanner(System.in);
    int limit = s.nextInt();
    int[] array1 = new int[limit];//{12,23, -22, 0, 43,545, -4, -55,43, 12,0, -999, -87

    System.out.println("Enter the numbers");
    for (int i = 0; i < limit; i++) {
      int lInput = s.nextInt();
      if (lInput >= 0) {
        p++;
      } else {
        n++;
      }
      array1[i] = lInput; 
    }
    int[] arrayPlus = new int[p];
    int[] arrayMinus = new int[n];

    int indexPlus = 0;
    int indexMinus = 0;
    for (int i = 0; i < limit; i++) {
      if (array1[i] >= 0) {
        arrayPlus[indexPlus] = array1[i];
        indexPlus++;
      } else {
        arrayMinus[indexMinus] = array1[i];
        indexMinus++;
      }
    }
    System.out.println("Positive array numbers");
    for (int i = 0; i < arrayPlus.length; i++) {
      System.out.println(arrayPlus[i]);
    }
    System.out.println("");

    System.out.println("Negative array numbers");
    for (int i = 0; i < arrayMinus.length; i++) {
      System.out.println(arrayMinus[i]);
    }
  }
}