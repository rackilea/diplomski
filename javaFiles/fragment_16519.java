Flux<Integer> g1 = Flux.generate(c -> {
            System.out.println(Thread.currentThread());
            c.next(1);
        });

        System.out.println(g1.take(5).collectList().block());

        Flux<Integer> g2 = g1.subscribeOn(Schedulers.elastic());

        System.out.println(g2.take(5).collectList().block());