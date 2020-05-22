public static void main(String[] args) {
    Observable.from(Arrays.asList("a", "b", "c"))
            .scan(new Tuple<>("", 0), (tuple, s) -> new Tuple<>(s, tuple.second + 1))
            .skip(1)
            .toMap(tuple -> "img" + tuple.second, tuple -> tuple.first)
            .subscribe(System.out::println);
}