private static void test(int... values) {
    TreeSet<Integer> ts = new TreeSet<>();
    System.out.println("Root is " + getTreeRoot(ts) + " for " + ts);
    for (int v : values) {
        ts.add(v);
        System.out.println("Root is " + getTreeRoot(ts) + " for " + ts);
    }
}