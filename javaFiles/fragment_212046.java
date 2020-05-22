public class Main {
    private int[] original = new int[] {1, 3, 5, 7, 9};
    private int[] random = new int[] {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        Main m = new Main();
        for (int i : m.random) {
            if (!contains(m.original, i))
                System.out.println(i);
        }
    }

    public static boolean contains(int[] array, int value) {
        for (int i : array)
            if (i == value)
                return true;

        return false;
    }
}