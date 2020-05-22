Observable<Vector<Integer>> list2 = Observable
    .range(1, 3)
    .reduce((Vector<Integer>)null, (vector, value) -> {
        if (vector == null) {
            vector = new Vector<>();
        }
        vector.add(value);
        return vector;
    });

list2.subscribe(System.out::println);
list2.subscribe(System.out::println);
list2.subscribe(System.out::println);