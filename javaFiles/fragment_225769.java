import java.util.Scanner;

public class Eliminating_duplicates {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of numbers: ");
    int numOfNums = input.nextInt();
    int[] list = new int[numOfNums];
    int[] newList = new int[numOfNums];
    for (int x = 0; x < list.length; ++x) {
      while (numOfNums != -1 && x < list.length) {
        System.out.print("Enter value " + (x + 1) + ": ");
        int value = input.nextInt();
        list[x] = value;
        ++x;
      }
    }
    sortList(list);
    System.out.println("Here is the sorted list: ");
    for (int x = 0; x < list.length; ++x) {
      System.out.println(list[x]);
    }
    newList = eliminateDuplicates(list);
    System.out.println("Here is the list without duplicates: ");
    for (int x = 0; x < newList.length; ++x) {
      System.out.println(newList[x]);
    }
  }

  public static void sortList(int[] list) {
    int temp;
    boolean madeASwap = true;
    int lastIndex = list.length - 1;
    while (madeASwap) {
      madeASwap = false;
      for (int x = 0; x < lastIndex; ++x) {
        if (list[x] > list[x + 1]) {
          temp = list[x];
          list[x] = list[x + 1];
          list[x + 1] = temp;
          madeASwap = true;
        }
      }

    }
  }

  public static int[] eliminateDuplicates(int[] list) {
    int end = list.length;
    for (int i = 0; i < end; i++) {
      for (int j = i + 1; j < end; j++) {
        if (list[i] == list[j]) {
          for (int k = j + 1; k < end; k++, j++) {
            list[j] = list[k];
          }
          --end;
          --j;
        }
      }
    }
    int[] newList = new int[end];
    for (int i = 0; i < end; i++) {
      newList[i] = list[i];
    }
    return newList;
  }
}