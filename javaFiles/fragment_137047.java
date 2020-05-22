import java.util.Arrays;

public class Sorting {

static void biggest(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        System.out.println(Arrays.toString(arr));
        int max, maxAt = i;
        for (int j = i; j < arr.length; j++) {
            maxAt = arr[j] > arr[maxAt] ? j : maxAt;
        }
        max = arr[maxAt];
        if (arr[i] < max) {
            arr[maxAt] = arr[i];
            arr[i] = max;
        }
    }
}

public static void main(String[] args) {
    int[] arr = {0, 1, 2, 3};
    biggest(arr);
    System.out.println(Arrays.toString(arr));
}
}