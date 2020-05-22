public class ProgressTask extends AsyncTask<String, Void, String> {

    private DefaultHttpClient httpclient;
    private ProgressDialog dialog;
    private Context context;

    private static final String URL = "";

    public ProgressTask(DefaultHttpClient client) {
        this.dialog = new ProgressDialog(context);
        this.httpclient = client;
    }
//this is used to interact with the view objects or its childs before making requests to the website
    protected void onPreExecute() {
        this.dialog.setMessage("Loading");
        this.dialog.show();
    }

    @Override
    protected void onPostExecute(String params) {
        if (dialog.isShowing()) {
            dialog.dismiss();

        }

        //do what you want (the onPostExecute method is used to interact with view objects or its child)
    }

//this code execute an async request to the URL page using POST and returns a string reponse to the onPostExecute method
    protected String doInBackground(final String... args) {
        HttpPost httppost = new HttpPost(URL);
        try {

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            return EntityUtils.toString(entity);

        } catch (ClientProtocolException e) {           // TODO Auto-generated catch block
        } catch (IOException e) {
        }

        return null;
    }
}