import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> bigList = List.of(0, 0, 1, 0, 1, 2, 0, 2, 3, 0, 3, 4, 0, 4, 5, 0, 5, 6, 0, 6, 7, 0, 7, 8, 0, 8, 9,
                1, 0, 2, 1, 1, 3, 1, 2, 4, 1, 3, 5, 1, 4, 6, 1, 5, 7, 1, 6, 8, 1, 7, 9, 1, 8, 1, 2, 0, 3, 2, 1, 4, 2, 2,
                5, 2, 3, 6, 2, 4, 7, 2, 5, 8, 2, 6, 9, 2, 7, 1, 2, 8, 2, 3, 0, 4, 3, 1, 5, 3, 2, 6, 3, 3, 7, 3, 4, 8, 3,
                5, 9, 3, 6, 1, 3, 7, 2, 3, 8, 3, 4, 0, 5, 4, 1, 6, 4, 2, 7, 4, 3, 8, 4, 4, 9, 4, 5, 1, 4, 6, 2, 4, 7, 3,
                4, 8, 4, 5, 0, 6, 5, 1, 7, 5, 2, 8, 5, 3, 9, 5, 4, 1, 5, 5, 2, 5, 6, 3, 5, 7, 4, 5, 8, 5, 6, 0, 7, 6, 1,
                8, 6, 2, 9, 6, 3, 1, 6, 4, 2, 6, 5, 3, 6, 6, 4, 6, 7, 5, 6, 8, 6, 7, 0, 8, 7, 1, 9, 7, 2, 1, 7, 3, 2, 7,
                4, 3, 7, 5, 4, 7, 6, 5, 7, 7, 6, 7, 8, 7, 8, 0, 9, 8, 1, 1, 8, 2, 2, 8, 3, 3, 8, 4, 4, 8, 5, 5, 8, 6, 6,
                8, 7, 7, 8, 8, 8);

        final AtomicInteger counter = new AtomicInteger(0);
        Collection<List<Integer>> smallerLists = bigList.stream()
                .collect(Collectors.groupingBy(i -> counter.getAndIncrement() / 9)).values();

        // Display the smaller lists
        smallerLists.stream().forEach(System.out::println);
    }
}