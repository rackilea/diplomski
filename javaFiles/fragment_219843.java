public static List<Integer> primeFactors2(int n) {
    ObjIntConsumer<ArrayList<Integer>> accumulator = (list, i) -> {
        if(n % i == 0 && list.stream().allMatch(p -> i % p != 0))
            list.add(i);
    };
    return IntStream.range(2, n - 1).collect(ArrayList::new, accumulator,
            (list1, list2) -> list2.forEach(i -> accumulator.accept(list1, i)));
}