AtomicInteger counter = new AtomicInteger();

    Observable.create(emitter -> {
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(1);
                    emitter.onNext(i);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }).start();
        for (int i = 0; i < 10000; i++) {
            Thread.sleep(1);
            emitter.onNext(i);

        }
    }).doOnNext(integer -> {
        if (counter.incrementAndGet() > 1)
            System.out.println("Whoaa!");
        counter.decrementAndGet();
        Thread.sleep(1);

    }).subscribe();