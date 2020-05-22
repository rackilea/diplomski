public class ODKortrijkWebservice extends AsyncTask<...> {

    private Callback mCallback;

    public interface Callback {
        void onSuccess(ArrayList<Winkel> winkels);
    }

    public ODKortrijkWebservice(Context context, Callback callback) {
        ...
        mCallback = callback;
        ...
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        ...
        mCallback.onSuccess(winkels);
    }
}