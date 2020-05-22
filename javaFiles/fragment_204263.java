return Observable.create(SyncOnSubscribe.createStateless(
        new Action1<Observer<? super Integer>>() {
            int counter = 0;

            @Override
            public void call(Observer<? super Integer> observer) {
                if (counter < 9) {
                    observer.onNext(counter++);
                } else {
                    observer.onCompleted();
                }
            }

        }));