public static void main (String[] args) throws Exception {
    int i = 555;
    Set<Integer> set = new HashSet<>();
    while(i > 0) {
        set.add(i % 10);
        i /= 10;
    }
    System.out.println(set);
}