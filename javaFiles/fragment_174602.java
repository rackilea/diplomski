public class SpecialAsyncTask<T> extends AsyncTask<String, Void, T> {

    public interface ResultProvider<T> {
        T generateResultInBackground(String... params);
    }

    public interface ResultConsumer<T> {
        void handleResultInForeground(T result);
    }

    private final ResultProvider<T> mProvider;
    private final ResultConsumer<T> mConsumer;
    private SpecialAsyncTask(ResultProvider<T> provider, ResultConsumer<T> consumer) {
        mProvider = provider;
        mConsumer = consumer;
    }

    @Override
    protected T doInBackground(String... params) {
        return mProvider.generateResultInBackground(params);
    }

    @Override
    protected void onPostExecute(T result) {
        mConsumer.handleResultInForeground(result);
    }

    public static <T> void execute(ResultProvider<T> provider, ResultConsumer<T> consumer, String... params) {
        new SpecialAsyncTask<T>(provider, consumer).execute(params);
    }
}