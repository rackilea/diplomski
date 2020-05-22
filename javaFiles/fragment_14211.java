public class ArrayToMap {

    public static void main(String[] args) {
        String[] arr = new String[]{"key1=value1","key2=value2"};

    Arrays.stream(arr)
            .map(s -> s.split("="))
            .collect(Collectors.toMap(sa -> sa[0], sb -> sb[1], (v1, v2)->v1));
    }
}