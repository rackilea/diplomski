public class WebDownloadTask extends AsyncTask<String, Void, String> {

    private AsyncResponse<String> callback;

    // Optional parameters
    private String username;
    private String password;

    // Make a constuctor to store the parameters
    public WebDownloadTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Don't forget to call this
    public void setCallback(AsyncResponse<String> callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(String... params) {
        String url = params[0];
        return readFromFile(url);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (callback != null) {
            callback.onResponse(s);
        } else {
            Log.w(WebDownloadTask.class.getSimpleName(), "The response was ignored");
        }
    }

    /******* private helper methods *******/

    private String streamToString(InputStream is) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    private String readFromFile(String myWebpage) {

        String response = null;
        HttpURLConnection urlConnection = null;

        try {
            //Get the url connection
            URL url = new URL(myWebpage);

            // Unnecessary for general AsyncTask usage
            /* 
            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password.toCharArray());
                }
            });
            */

            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = urlConnection.getInputStream();

            if (inputStream != null) {
                response = streamToString(inputStream);
                inputStream.close();
                Log.d("Final String", response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return response;
    }
}