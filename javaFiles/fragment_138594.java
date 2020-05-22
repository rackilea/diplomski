public class EvenAppearBeforeOdd {    
    static void rearrangeEvenAndOdd(int arr[]) {
        int j = 0, temp;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
    }
    static void printArray(int arr[]) {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"\t");
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = { 15, 9, 1, 3, 10, 5, 4, 8 };
        System.out.println("Before:");
        printArray(arr);
        rearrangeEvenAndOdd(arr);
        System.out.println("After:");
        printArray(arr);
    }
}