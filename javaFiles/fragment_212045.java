import java.util.stream.IntStream;

public class Main {
    private int[] original = new int[] {1, 3, 5, 7, 9};
    private int[] random = new int[] {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        Main m = new Main();
        for (int i : m.random) {
            if (IntStream.of(m.original).noneMatch(value -> value == i))
                System.out.println(i);
        }
    }
}