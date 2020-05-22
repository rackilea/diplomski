Observable<String> event = Observable.just("My Input");
// false - paused by default
final BehaviorSubject<Boolean> pauser = BehaviorSubject.create(false);

event
    .flatMap(new Func1<String, Observable<String>>() {
        @Override
        public Observable<String> call(final String input) {
            return pauser
                    .distinctUntilChanged()
                    .filter(new Func1<Boolean, Boolean>() {
                        @Override
                        public Boolean call(Boolean resumed) {
                            return resumed;
                        }
                    })
                    .map(new Func1<Boolean, String>() {
                        @Override
                        public String call(Boolean resumed) {
                            return input;
                        }
                    });
        }
    })
    .subscribe(new Action1<String>() {
        @Override
        public void call(String input) {
            // handle input
        }
    });