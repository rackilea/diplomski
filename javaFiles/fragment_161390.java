import static java.util.stream.Collectors.toMap;
import static java.lang.Math.min;

...

static Map<Integer, List<Integer>> partition(List<Integer> list, int pageSize) {
    return IntStream.iterate(0, i -> i + pageSize)
          .limit((list.size() + pageSize - 1) / pageSize)
          .boxed()
          .collect(toMap(i -> i / pageSize,
                         i -> list.subList(i, min(i + pageSize, list.size()))));
}