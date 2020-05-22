PublishSubject<Notification<String>> subject = PublishSubject.create();

subject.subscribe(System.out::println);

subject.onNext(Notification.createOnNext("Hello"));
subject.onNext(Notification.<String>createOnError(new RuntimeException("oops")));
subject.onNext(Notification.createOnNext("World"));