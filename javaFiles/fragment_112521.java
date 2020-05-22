Flux.fromIterable(IntStream.range(0, 20).boxed().collect(Collectors.toList()))
            .map(i -> {
                System.out.println("map [" + Thread.currentThread().getName() + "] " + i);
                return i;
            })
            .elapsed()
            .publishOn(Schedulers.single())
            .subscribeOn(Schedulers.single())
            .subscribe(t2 -> {
                System.out.println("subscribe [" + Thread.currentThread().getName() + "] " + t2);
            });