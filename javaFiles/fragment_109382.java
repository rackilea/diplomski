public void test() {
    Integer[] a = randomData(10000000);

    ArrayList<Integer> integerList = new ArrayList<>();
    for (Integer i : a) {
        integerList.add(i);
    }

    long t0, t1;
    //Sort by ArrayList
    t0 = System.currentTimeMillis();
    integerList.sort(((p1, p2) -> (p1.intValue() < p2.intValue() ? -1 : p1.intValue() > p2.intValue() ? 1 : 0)));
    t1 = System.currentTimeMillis();
    System.out.println("ArrayList duration:" + (t1 - t0));


    //Sort by Arrays
    Integer[] integerArray = Arrays.copyOf(a, a.length);
    t0 = System.currentTimeMillis();
    Arrays.sort(integerArray, ((p1, p2) -> (p1.intValue() < p2.intValue() ? -1 : p1.intValue() > p2.intValue() ? 1 : 0)));
    t1 = System.currentTimeMillis();
    System.out.println("Arrays duration:" + (t1 - t0));

}

Random r = new Random(System.currentTimeMillis());

private Integer[] randomData(int n) {
    Integer[] a = new Integer[n];
    for (int i = 0; i < n; i++) {
        a[i] = r.nextInt();
    }
    return a;
}