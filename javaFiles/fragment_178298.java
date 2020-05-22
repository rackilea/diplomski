Observable.range(1, 10)
            .groupBy(v -> v % 2 == 0)
            .doOnNext(group -> System.out.println("key: " + group.getKey()))
            .toMap(g -> g.getKey())
            .doOnSuccess(map -> System.out.println("map: " + map.size()))
            .flatMapObservable(m -> Observable.merge(
                    m.get(true),
                    m.get(false)
            ))
            .subscribe(System.out::println);