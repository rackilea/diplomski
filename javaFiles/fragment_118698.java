Phaser phaser = new Phaser(1);

Flux.just(1, 2, 3, 4, 5)
        .doOnSubscribe(s -> phaser.register())
        .delayElements(Duration.ofMillis(500))
        .doFinally(s -> phaser.arriveAndDeregister())
        .subscribe(System.out::println);

Flux.just(1, 2, 3, 4, 5, 6, 7, 8)
        .doOnSubscribe(s -> phaser.register())
        .delayElements(Duration.ofMillis(500))
        .doFinally(s -> phaser.arriveAndDeregister())
        .subscribe(System.out::println);

phaser.arriveAndAwaitAdvance();