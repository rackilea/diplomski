public abstract class CallbackWithRetry<T> implements Callback<T> {

    private static final int TOTAL_RETRIES = 3;
    private static final String TAG = CallbackWithRetry.class.getSimpleName();
    private final Call<T> call;
    private int retryCount = 0;

    public CallbackWithRetry(Call<T> call) {
        this.call = call;
    }

    @Override
    public void onFailure(Throwable t) {
        Log.e(TAG, t.getLocalizedMessage());
        if (retryCount++ < TOTAL_RETRIES) {
            Log.v(TAG, "Retrying... (" + retryCount + " out of " + TOTAL_RETRIES + ")");
            retry();
        }
    }

    private void retry() {
        call.clone().enqueue(this);
    }
}