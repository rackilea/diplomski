public class Duplicates {
    public static void main(String[] args) {
        int[] list = new int[]{1, 4, 2, 6, 7, 5, 1, 2};
        int temp;

        for (int i = 0; i < list.length; ++i) {
            for (int j = 1; j < (list.length - i); ++j) {
                if (list[j - 1] > list[j]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }
        }

        int n = 0, counter = 0;
        int previous = -1;
        for (int i = 0; i < list.length; ++i) {
            if (list[i] == previous) {
                ++n;
                if (n == 1) {
                    ++counter;
                    if (counter == 1) {
                        System.out.print(list[i]);
                    } else {
                        System.out.print(", " + list[i]);
                    }
                }
            } else {
                previous = list[i];
                n = 0;
            }
        }

        System.out.println("\nNumber of Duplicated Numbers in array: " + counter);
    }
}