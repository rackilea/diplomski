public class Temp {
    public static void main(String[] args) {
        int[][] arr = { { 1,2,3,4 },
                        { 2,3,4,1 },
                        { 3,4,1,2 },
                        { 4,1,2,3 } };

        int patch = 2;

        splitToSubArrays(arr, patch);

    }

    static void splitToSubArrays(int arr[][], int patch) {
        for (int i = 0; i < arr[0].length; i++) {
            int to = patch;
            for (int from = 0; to <= arr.length;) {
                int a[] = Arrays.copyOfRange(arr[i], from, to);
                // instead of printing you can store in a separate array for later usage
                System.out.println(Arrays.toString(a));
                to += patch;
                from += patch;
            }
        }
    }

}