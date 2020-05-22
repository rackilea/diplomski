import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

Stream<Integer> ranges = Stream.iterate(1, i -> i + 1).limit(15);
List<Integer> collect = ranges
    .sorted(Comparator.reverseOrder()) // sort the stream from the highest to the smallest
    .skip(1)                           // discards 1 element from the beginning
    .sorted()                          // sort the stream from the smallest to the highest
    .skip(1)                           // discards 1 element from the beginning
    .collect(Collectors.toList())     
    ;