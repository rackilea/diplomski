return Observable.create(SyncOnSubscribe.createStateful(
        () -> 0,
        (counter, observer) -> {
            if (counter < 9) {
                observer.onNext(counter);
            } else {
                observer.onCompleted();
            }
            return counter + 1;
        }
));