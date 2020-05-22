public abstract class AsyncTaskWrapper<Params, Progress, Result> extends
        AsyncTask<Params, Progress, Result> {

    protected Exception error;

    protected Result doInBackground(Params... params) {
        try {
            init();

            return doRealWork(params);
        } catch (Exception e) {
            error = e;

            Log.e("TAG", e.getMessage(), e);

            return null;
        }
    }

    protected abstract void init();

    protected abstract Result doRealWork(Params... params);
}