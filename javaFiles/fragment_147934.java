public class EBOMain {

    static int[] array = { 1, 2, 3, 4, 5, 6 };

    public static void main(String[] args) {

        System.out.print("array before sort: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        rearrange(array, array.length);  // <-- Change is here

        System.out.print("\narray after sort: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void rearrange(int[] array, int n) {
        if (n == 0) {
            return;
        } else if (array[n - 1] % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                if (array[i] % 2 != 0) {
                    int temp = array[i];
                    array[i] = array[n - 1];
                    array[n - 1] = temp;

                    rearrange(array, n - 1);
                }
            }
        } else {
            rearrange(array, n - 1);
        }
    }
}