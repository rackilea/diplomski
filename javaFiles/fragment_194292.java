public static List<String> duplicate(List<String> al, int n) {
    List<String> ret = new ArrayList<>();
    for (String s : al) {
        for (int i = 0; i < n; i++) {
            ret.add(s);
        }
    }
    return ret;
}

public static void main(String[] args) {
    System.out.println(duplicate(Arrays.asList("dog", "cat"), 3));
}