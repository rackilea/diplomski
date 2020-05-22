Flux.fromIterable(IntStream.range(0, 20).boxed().collect(Collectors.toList()))
        .elapsed()
        .parallel()
        .runOn(Schedulers.parallel())
        .subscribe(t2 -> {
            System.out.println("[" + Thread.currentThread().getName() + "] " + t2);
            try {
                Thread.sleep(1000); // long operation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, throwable -> {
            System.err.println("[" + Thread.currentThread().getName() + "] Error: " + throwable.getMessage());
        }, () -> {
            System.out.println("[" + Thread.currentThread().getName() + "] Complete");
        }, subscription -> {
            System.out.println("[" + Thread.currentThread().getName() + "] Subscription");
            subscription.request(Long.MAX_VALUE);
        });