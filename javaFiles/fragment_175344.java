public static void main(String[] args) {
    Set<String> set = new HashSet<>();
    set.add("hello");
    set.add("world");

    Vector<Set<String>> v = new Vector<>();
    v.add(set);

    set.clear();

    System.out.println(v);
}