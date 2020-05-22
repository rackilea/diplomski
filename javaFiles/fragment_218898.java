import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.of;

static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    return of(nums1)
            .mapToObj(v1 -> of(nums2).mapToObj(v2 -> asList(v1, v2)).collect(toList()))
            .flatMap(List::stream)
            .sorted(comparingInt(o -> o.stream().mapToInt(i -> i).sum()))
            .limit(k).collect(toList());
}