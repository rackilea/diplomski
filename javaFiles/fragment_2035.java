public interface ListenableFutureCallback<T> extends SuccessCallback<T>, FailureCallback {

}

@FunctionalInterface
public interface SuccessCallback<T> {

    /**
     * Called when the {@link ListenableFuture} completes with success.
     * <p>Note that Exceptions raised by this method are ignored.
     * @param result the result
     */
    void onSuccess(@Nullable T result);

}

@FunctionalInterface
public interface FailureCallback {

    /**
     * Called when the {@link ListenableFuture} completes with failure.
     * <p>Note that Exceptions raised by this method are ignored.
     * @param ex the failure
     */
    void onFailure(Throwable ex);

}