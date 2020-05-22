public static JSONObject SendHttpGet(String URL, JSONObject jsonObjSend) {

    try {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPostRequest = new HttpPost(URL);

        StringEntity se;
        se = new StringEntity(jsonObjSend.toString());

        // Set HTTP parameters
        httpPostRequest.setEntity(se);
        httpPostRequest.setHeader("X-Parse-Application-Id", APP ID);
        httpPostRequest.setHeader("X-Parse-REST-API-Key", REST API KEY);
        httpPostRequest.setHeader("Accept", "application/json");
        httpPostRequest.setHeader("Content-type", "application/json");
        //httpPostRequest.setHeader("Accept-Encoding", "gzip"); // only set this parameter if you would like to use gzip compression

        long t = System.currentTimeMillis();
        HttpResponse response = (HttpResponse) httpclient.execute(httpPostRequest);
        Log.i(TAG, "HTTPResponse received in [" + (System.currentTimeMillis()-t) + "ms]");

        // Get hold of the response entity (-> the data):
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            // Read the content stream
            InputStream instream = entity.getContent();
            Header contentEncoding = response.getFirstHeader("Content-Encoding");
            if (contentEncoding != null && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
                instream = new GZIPInputStream(instream);
            }

            // convert content stream to a String
            String resultString= convertStreamToString(instream);
            Log.d("JSON RESULT", resultString);
            instream.close();
            resultString = resultString.substring(1,resultString.length()-1); // remove wrapping "[" and "]"

            // Transform the String into a JSONObject
            JSONObject jsonObjRecv = new JSONObject(resultString);
            // Raw DEBUG output of our received JSON object:
            Log.i(TAG,"<JSONObject>\n"+jsonObjRecv.toString()+"\n</JSONObject>");

            return jsonObjRecv;
        }

    }
    catch (Exception e)
    {
        // More about HTTP exception handling in another tutorial.
        // For now we just print the stack trace.
        e.printStackTrace();
    }
    return null;
}