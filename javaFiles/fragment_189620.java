public class MyCallback<T> implements AsyncCallback<T> {

    public MyCallback() {
    }

    @Override
    public void onFailure(T result) {
        /*
         * Show standard error message. You can override it
         * with a more specific message where necessary.
         */
    }

    @Override
    public void onSuccess(T result) {
        execute(result);
        // Call your timer, etc.
    }

    protected void execute(T result) {
        // Override this method when making calls.
    }
}