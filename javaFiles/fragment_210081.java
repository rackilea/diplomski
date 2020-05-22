// somewhere before
PublishSubject stopNotifier = PublishSubject.create();

// somewhere process the queue
Observable.timer(0, 1, TimeUnit.SECOND)
    .takeUntil(stopNotifier)
    .flatMap(tick -> Observable.just(queue.poll()))
    .subscribe(layer -> System.out.format("The layer is : %s",  layer));

// when not anymore interested (calling onComplete works too)
stopNotifier.onNext("cancel everything about the queue");