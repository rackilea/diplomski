public class HttpAsyncTask extends AsyncTask<String, Void, String> {
    private final String ID, Image, Nummer;

    public HttpAsyncTask(String ID, String Image, String Nummer) {
        this.ID = ID;
        this.Image = Image;
        this.Nummer = Nummer;
    }

    protected String doInBackground(String... urls) {
        return POST(urls[0], ID, Image, Nummer);
    }

    protected void onPostExecute(String result) {
        [...]
    }
}