final List<Integer> first  = Lists.newArrayList(1, 2, 3);
final List<Integer> second = Lists.newArrayList(4, 5, 6);
final List<Integer> third  = Lists.newArrayList(7, 8, 9);
final Iterable<Integer> all =
    Iterables.unmodifiableIterable(
        Iterables.concat(first, second, third));
System.out.println(all);
third.add(9999999);
System.out.println(all);