SortedSet<Integer> s1 = new TreeSet<>();
SortedSet<Integer> s2 = new TreeSet<>();
SortedSet<Integer> s3 = new TreeSet<>();
SortedSet<Integer> s4 = new TreeSet<>();

// ...

MultiSortedSetView<Integer> v =
        new MultiSortedSetView<Integer>()
            .add(s1)
            .add(s2)
            .add(s3)
            .add(s4);

for (final Integer i: v) {
    System.out.println(i);
}