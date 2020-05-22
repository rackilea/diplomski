private static class RxCallAdapterWrapper<T> implements CallAdapter<Observable<T>> {
    private final CallAdapter<T> wrapped;
    @Override
    public <R> Observable<T> adapt(Call<R> call) {
        Observable<T> observableWrapped = wrapped.adapt(call);
        return observableWrapped.onErrorResumeNext(throwable -> {

            if (notHasNetworkConnection()) {
                return Observable.error(new NoConnectionException());// Here happens the error
            }

            return Observable.error(throwable);
        });
    }
.... Other code
}