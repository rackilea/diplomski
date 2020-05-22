import java.util.Random;

public class Quicksort
{
     private static Random rand = new Random();

     public static void quicksort(int[] arr, int left, int right)
     {
          if (left < right)
          {
               int pivot = randomizedPartition(arr, left, right);
               quicksort(arr, left, pivot);
               quicksort(arr, pivot + 1, right);
          }
     }

     private static int randomizedPartition(int[] arr, int left, int right)
     {
          int swapIndex = left + rand.nextInt(right - left) + 1;
          swap(arr, left, swapIndex);
          return partition(arr, left, right);
     }

     private static int partition(int[] arr, int left, int right)
     {
          int pivot = arr[left];
          int i = left - 1;
          int j = right + 1;
          while (true)
          {
               do
                    j--;
               while (arr[j] > pivot);

               do
                    i++;
               while (arr[i] < pivot);

               if (i < j)
                    swap(arr, i, j);
               else
                    return j;
          }
     }

     private static void swap(int[] arr, int i, int j)
     {
          int tmp = arr[i];
          arr[i] = arr[j];
          arr[j] = tmp;
     }

     // Sort 100k elements that are in reversed sorted order
     public static void main(String[] args)
     {
          int arr[] = new int[100000];
          for (int i = 0; i < arr.length; i++)
               arr[i] = arr.length - i;

          System.out.println("First 20 elements");
          System.out.print("Before sort: ");
          for (int i = 0; i < 20; i++)
               System.out.print(arr[i] + " ");
          System.out.println();

          quicksort(arr, 0, arr.length - 1);
          System.out.print("After sort: ");
          for (int i = 0; i < 20; i++)
               System.out.print(arr[i] + " ");
          System.out.println();
     }

}