enum Irrelevant { INSTANCE; }

PublishSubject<Irrelevant > source = PublishSubject.create();

source.subscribe(e -> { /* Ignored. */ }, Throwable::printStackTrace);

source.onNext(Irrelevant.INSTANCE);
source.onNext(Irrelevant.INSTANCE);