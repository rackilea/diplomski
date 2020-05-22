private final PublishSubject<String> subject = PublishSubject.create();

public Observable<String> getUiElementAsObservable() {
    return subject;
}

public void updateUiElementValue(final String value) {
    subject.onNext(value);
}