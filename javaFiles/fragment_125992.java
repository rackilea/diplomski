import java.util.Scanner;

public class Quickie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int temp;

        int size = sc.nextInt();

        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            temp = sc.nextInt();
            list[i] = temp;
        }
        int end = size - 1;
        CounterClass count = new CounterClass(0);

        quickSort(list, 0, end, count);

        int firstElement = list[0];
        int lastElement = list[size - 1];
        System.out.println("Number of pivots: " + count.getCount());
        System.out.println("First Element: " + firstElement);
        System.out.println("Last Element: " + lastElement);
    }
    private static void quickSort (int []arr, int start, int end, CounterClass count){
        int partition = partition(arr, start, end, count);

        if (partition-1>start){
            quickSort(arr, start, partition-1,count);
        }
        if (partition+1<end){
            quickSort(arr, partition+1,end,count);
        }
    }
    private static int partition (int[]arr, int start, int end, CounterClass count){
        int pivot = arr[start];

        count.count++;
        int pointer = start+1;
        int i =pointer;
        for (int j=pointer; j<=end;j++){
            if (arr[j]<pivot){
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
            }
        }
        i-=1;

        int temp=arr[start];
        arr[start]=arr[i];
        arr[i]=temp;
        return (i);
    }



}


class CounterClass{
    int count;
    public CounterClass(int count){
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}