import java.util.*;

public class BubbleSort {

    public static void main(String...args) {
        Scanner sc = new Scanner(System.in);

        int[] a = acquireArray(sc);
        int[] b = acquireArray(sc);
        int[] c = merge(a,b);
        bubbleSort(c);
        printArray(c);

    }

    public static int[] acquireArray(Scanner sc) {
        System.out.println("Length? ");
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            System.out.println("Enter element " + (i+1) + ":");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static int[] merge(int[] a , int[] b) {
        int[] c = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b,0,c,a.length,b.length);
        return c;
    }

    public static void bubbleSort(int[] a) {
        boolean swapped = true;
        int j = 0;
        while(swapped) {
            swapped = false;
            j++;
            for(int i = 0; i < a.length - j; i++) {
                if(a[i] > a[i+1]) {
                    int t = a[i];
                    a[i] = a[i+1];
                    a[i+1] = t;
                    swapped = true;
                }
            }
        }
    }

    public static void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }

}