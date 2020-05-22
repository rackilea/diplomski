private final BehaviorSubject<Integer> subject = BehaviorSubject.create();
private Integer value=0;

public Observable<Integer> getUiElementAsObservable() {
    return subject;
}

public void updateUiElementValue(final Integer valueAdded) {
    synchronized (value) {
        if (value + valueAdded < 0)
            return;
        value += valueAdded;
        subject.onNext(value);
    }
}