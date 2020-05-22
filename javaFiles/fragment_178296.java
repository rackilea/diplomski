Observable.range(1, 10)
            .groupBy(v -> v % 2 == 0)
            .doOnNext(group -> System.out.println("key: " + group.getKey()))
            .flatMap(group -> {
                if (group.getKey()) {
                    return group;
                }
                return group;
            })
            .subscribe(System.out::println);