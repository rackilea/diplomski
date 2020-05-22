import java.util.stream.Collectors;
import java.util.Map;
import java.util.List;
import java.util.Arrays;

public class Partition {

    public static String join(int[] a, String d) {
        return Arrays.stream(a).mapToObj(String::valueOf)
                     .collect(Collectors.joining(d));
    }

    public static void main(String[] args) {
        int[] v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 4;
        Map<Boolean, List<Integer>> partitions = Arrays.stream(v)
            .boxed()
            .filter(n -> n != k)
            .collect(Collectors.partitioningBy(n -> n < k));

        int[] vlt = partitions.get(true).stream()
                              .mapToInt(Integer::intValue).toArray();
        int[] vgt = partitions.get(false).stream()
                              .mapToInt(Integer::intValue).toArray();

        System.out.println("vlt: {" + join(vlt, ", ") + "}");
        System.out.println("vgt: {" + join(vgt, ", ") + "}");
    }

}