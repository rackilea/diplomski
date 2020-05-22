// A little helper to avoid the awkward syntax
// Arrays.asList(new String [] { "one", "two" })
public static List<String> listOf(String ... strings) {
    return Arrays.asList(strings);
}

public static void main(String[] args) {
    List<List<String>> left = new ArrayList<>();
    left.add(listOf("one", "two"));

    List<List<String>> right = new ArrayList<>();
    right.add(listOf("one", "two"));

    System.out.println(left.equals(right) ? "Yeah!" : "This is not what I want.");
}