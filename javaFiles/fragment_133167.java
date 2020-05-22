Observable.range(1, 10)
    .groupBy(v -> v % 2 == 0)
    .flatMap(group -> {
        if (group.getKey()) {
           return group.map(v -> v + 1);
        }
        return group.map(v -> v - 1);
    })
    .subscribe(System.out::println);