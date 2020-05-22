public void sort(int[] sort) {
    StringJoiner sj = new StringJoiner(",");
    for (int a : sort) {
        sj.add(String.valueOf(a));
    }
    System.out.println(sj.toString());
}