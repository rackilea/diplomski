public static void main(String[] args) {
    List<Integer> first = Arrays.asList(1, 3, 5, 7, 9);
    List<Integer> second = Arrays.asList(1, 5, 12);

    Set<Integer> first_set = new HashSet<>(first);
    Set<Integer> second_set = new HashSet<>(second);

    System.out.println(Sets.difference(first_set, second_set));
    System.out.println(Sets.difference(second_set, first_set));
    System.out.println(Sets.intersection(first_set, second_set));
    System.out.println(Sets.union(first_set, second_set));
}