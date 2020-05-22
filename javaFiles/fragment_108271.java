public class JSONTask extends AsyncTask<String, String, String> {

    public JSONTask(AsyncResponse delegate) {
        this.delegate = delegate
    }

    AsyncResponse delegate = null;

    @Override
    protected String doInBackground(String... params) {
        // [...]