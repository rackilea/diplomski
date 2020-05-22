private static <T, C> Observable<T> combine(Observable<T> source, Observable<C> control, BiFunction<T, C, Boolean> predicate) {
    return Observable.create(emitter -> {
        Queue<T> buffer = new ArrayDeque<>();
        AtomicReference<C> lastControl = new AtomicReference<>();
        CompletableSubject sourceCompletable = CompletableSubject.create();
        CompletableSubject controlCompletable = CompletableSubject.create();
        Disposable disposable = new CompositeDisposable(
                control.subscribe(
                        val -> {
                            lastControl.set(val);
                            synchronized (buffer) {
                                while (!buffer.isEmpty() && predicate.apply(buffer.peek(), val)) {
                                    emitter.onNext(buffer.poll());
                                }
                            }
                        },
                        emitter::onError,
                        controlCompletable::onComplete),
                source.subscribe(
                        val -> {
                            C lastControlVal = lastControl.get();
                            synchronized (buffer) {
                                if (lastControlVal != null && predicate.apply(val, lastControlVal)) {
                                    emitter.onNext(val);
                                } else {
                                    buffer.add(val);
                                }
                            }
                        },
                        emitter::onError,
                        sourceCompletable::onComplete),
                controlCompletable.andThen(sourceCompletable).subscribe(emitter::onComplete));
        emitter.setDisposable(disposable);
    });
}