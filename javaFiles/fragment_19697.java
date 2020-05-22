/**
 * An AsyncTask implementation for performing GETs on the Hypothetical REST APIs.
 */
public class GetTask extends AsyncTask<String, String, String>{

    private String mRestUrl;
    private RestTaskCallback mCallback;

    /**
     * Creates a new instance of GetTask with the specified URL and callback.
     * 
     * @param restUrl The URL for the REST API.
     * @param callback The callback to be invoked when the HTTP request
     *            completes.
     * 
     */
    public GetTask(String restUrl, RestTaskCallback callback){
        this.mRestUrl = restUrl;
        this.mCallback = callback;
    }

    @Override
    protected String doInBackground(String... params) {
        String response = null;
        //Use HTTP Client APIs to make the call.
        //Return the HTTP Response body here.
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        mCallback.onTaskComplete(result);
        super.onPostExecute(result);
    }
}

    /**
     * An AsyncTask implementation for performing POSTs on the Hypothetical REST APIs.
     */
    public class PostTask extends AsyncTask<String, String, String>{
        private String mRestUrl;
        private RestTaskCallback mCallback;
        private String mRequestBody;

        /**
         * Creates a new instance of PostTask with the specified URL, callback, and
         * request body.
         * 
         * @param restUrl The URL for the REST API.
         * @param callback The callback to be invoked when the HTTP request
         *            completes.
         * @param requestBody The body of the POST request.
         * 
         */
        public PostTask(String restUrl, String requestBody, RestTaskCallback callback){
            this.mRestUrl = restUrl;
            this.mRequestBody = requestBody;
            this.mCallback = callback;
        }

        @Override
        protected String doInBackground(String... arg0) {
            //Use HTTP client API's to do the POST
            //Return response.
        }

        @Override
        protected void onPostExecute(String result) {
            mCallback.onTaskComplete(result);
            super.onPostExecute(result);
        }
    }

    /**
     * Class definition for a callback to be invoked when the HTTP request
     * representing the REST API Call completes.
     */
    public abstract class RestTaskCallback{
        /**
         * Called when the HTTP request completes.
         * 
         * @param result The result of the HTTP request.
         */
        public abstract void onTaskComplete(String result);
    }