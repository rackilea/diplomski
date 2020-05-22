public static void main(String[] args) {
    List<List<Integer>> al = Arrays.asList( //
            Arrays.asList(5, 4, 0), Arrays.asList(3, 2, 1), //
            Arrays.asList(3, 3, 3), Arrays.asList(2, 2, 2));
    Collections.sort(al, (a, b) -> a.get(2).compareTo(b.get(2)));
    // Collections.sort(al, (a, b) -> Integer.compare(a.get(2), b.get(2)));
    System.out.println(al);
}