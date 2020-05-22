public static void main(String[] args) {
    List<String> l = initList();
    l.set(0, "activity 1");
    l.set(5, "activity 2");
    System.out.println(l);
}

private static List<String> initList() {
    final List<String> l = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
        l.add(""); // or null, but this can cause some problems ... (try to find an empty representation for an "activity" instance)
    }
    return l;
}