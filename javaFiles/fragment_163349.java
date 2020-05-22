import java.util.Arrays;

public class Test {
    public static int count(int[] arr, int b) {
        int maxCount = 0, curCount = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; ++i) {
            curCount = 0;
            for (int j = i; j < arr.length; ++j) {
                if (arr[j]-arr[i] <= b) {
                    ++curCount;
                } else {
                    break;
                }
            }
            maxCount = Math.max(maxCount, curCount);
         }
         return maxCount;
    }

    public static void main(String[] args) {
        int b = 3;
        int [] arr = {1,6,4,3,1};
        System.out.println("count: " + count(arr, b));
    }
}