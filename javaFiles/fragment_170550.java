public static void main(String[] args) {

    final SortedMultiset<Integer> set1 = ImmutableSortedMultiset.of(1, 2, 2, 3, 3, 3);
    final SortedMultiset<Integer> set2 = ImmutableSortedMultiset.of(1, 1, 2, 4);
    final SortedMultiset<Integer> sum = ImmutableSortedMultiset.copyOf(Multisets.sum(set1, set2));
    System.out.println(sum);
}