Integer a[] = { 10, 20, 30, 10, 10, 20, 50, 60, 50, 50 };
Set<Integer> noDuplicateInt = new HashSet<>();
for (Integer integer : a) {
    if (noDuplicateInt.add(integer)) {
        System.out.println("Number of Occurence of " + integer + ": " +
                   Collections.frequency(Arrays.asList(a), integer));
    }
}