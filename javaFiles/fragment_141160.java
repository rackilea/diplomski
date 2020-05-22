public static JSONObject SendHttpPost(Context context, JSONObject jsonObjSend) {
        mPrefs = AppConfig.getPreferences(context);
        String username = mPrefs.getString("UserName","");
        String password = mPrefs.getString("Password","");
        String host = mPrefs.getString("URL","");
        String port = mPrefs.getString("Port","");
        String url = "http:\\myapp.com\controller\getuser"


    HttpResponse response = null ;


    JSONObject jsonObjRecv =null;
    try {
        String usercredential = Utility.getB64Auth(username, password);
        DefaultHttpClient httpclient = new DefaultHttpClient();

        HttpPost httpPostRequest = new HttpPost(url);
        StringEntity se;
        se = new StringEntity(jsonObjSend.toString());

        // Set HTTP parameters
        httpPostRequest.setEntity(se);
        httpPostRequest.setHeader("Authorization", usercredential);
        httpPostRequest.setHeader("Accept", "application/json");
        httpPostRequest.setHeader("Content-type", "application/json");

        long t = System.currentTimeMillis();
        response = (HttpResponse) httpclient.execute(httpPostRequest);
        Log.i(TAG, "HTTPResponse received in [" + (System.currentTimeMillis()-t) + "ms]");
        //Get hold of the response entity (-> the data):
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
            Log.v(null, "resultString "+resultString);
            instream.close();


            // Transform the String into a JSONObject
            if(resultString!=null){
                jsonObjRecv = new JSONObject(resultString);

            }

            // Raw DEBUG output of our received JSON object:
            Log.i(TAG,"<jsonobject>\n"+jsonObjRecv.toString()+"\n</jsonobject>");

            return jsonObjRecv;
        } 


    } catch(SocketException se){
        se.printStackTrace();


    }catch (ClientProtocolException e)  {

        e.printStackTrace();
    } catch (IOException e) {

        e.printStackTrace();
    } catch (JSONException e) {

        e.printStackTrace();
    }
    return null;
}