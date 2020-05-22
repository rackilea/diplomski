public Completable someMethod() {
    Log.d(TAG, "someMethod");

    // doA() inlined
    LOG.d("class call");
    Completable a = ...

    // doB() inlined
    Log.d("class call");
    Completable b = ...

    return a.andThen(b);
}