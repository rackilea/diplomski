public class JSONClient extends AsyncTask<URLWithParams, Void, String> {
    private final static String TAG = "JSONClient";

    ProgressDialog progressDialog ;
    GetJSONListener getJSONListener;
    public JSONClient(GetJSONListener listener){
        this.getJSONListener = listener;
    }

    @Override
    protected String doInBackground(URLWithParams... urls) {
        return connect(urls[0].url, urls[0].nameValuePairs);
    }

    public static String connect(String url, List<NameValuePair> pairs)
    {
        HttpClient httpclient = new DefaultHttpClient();

        if(url == null)
        {
            Log.d(TAG, "want to connect, but url is null");
        }
        else
        {
            Log.d(TAG, "starting connect with url " + url);
        }

        if(pairs == null)
        {
            Log.d(TAG, "want to connect, though pairs is null");
        }
        else
        {
            Log.d(TAG, "starting connect with this many pairs: " + pairs.size());
            for(NameValuePair dog : pairs)
            {
                Log.d(TAG, "example: " + dog.toString());
            }
        }

        // Execute the request
        HttpResponse response;
        try {
            // Prepare a request object
            HttpPost httpPost = new HttpPost(url); 
            httpPost.setEntity(new UrlEncodedFormEntity(pairs));
            response = httpclient.execute(httpPost);
            // Examine the response status
            Log.i(TAG,response.getStatusLine().toString());

            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
            String json = reader.readLine();
            return json;

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }



    @Override
    protected void onPostExecute(String json ) {
        getJSONListener.onRemoteCallComplete(json);
    }


    public interface GetJSONListener {
        public void onRemoteCallComplete(String jsonFromNet);
    }

}