Observable<Vector<Integer>> list = Observable
    .range(1, 3)
    .reduce(new Vector<Integer>(), (vector, value) -> {
        vector.add(value);
        return vector;
    });

list.subscribe(System.out::println);
list.subscribe(System.out::println);
list.subscribe(System.out::println);