package snippet;

public class Snippet {

    public static void main(String[] args) {
        System.out.println(QSequence(10));
    }

    public static int QSequence(int n) {
        int result;
        int[] arr;
        int value;

        arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - arr[i - 1]] + arr[i - arr[i - 2]];
        }

        return arr[n - 1];
    }
}