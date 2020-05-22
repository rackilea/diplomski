java.net.URL url=null;
    try {
        url = new java.net.URL(SOAP_ACTION);
    } catch (MalformedURLException e) {
        Log.e(TAG, "Bad URL",e);
    }
    JSONObject obj=new JSONObject();
    try {
        String value_key="Value";
        obj.put(value_key, value);
        Log.d(TAG,obj.toString());
    } catch (JSONException e) {
        Log.e(TAG, "Create JSONObjerct throws an error");
    }
    HttpURLConnection urlConnection = null;
    try {
        urlConnection = (HttpURLConnection)url.openConnection();
    } catch (IOException e1) {
        Log.e(TAG,"Error opening connection",e1);
    }
    urlConnection.setDoOutput(true);
    try {
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Accept", "*/*");
        //urlConnection.addRequestProperty("Accept-Encoding", "gzip deflate sdch");
        urlConnection.setRequestProperty("Content-Type","application/json");
    } catch (ProtocolException e) {
        Log.e(TAG,"Error setting header",e);
    }
    try {
        urlConnection.connect();
        DataOutputStream dos=new DataOutputStream(urlConnection.getOutputStream());
        dos.write(obj.toString().getBytes());
        int response=urlConnection.getResponseCode();
        Log.d(TAG, "Response code: "+response);
        urlConnection.disconnect();
    } catch (IOException e) {
        Log.e(TAG,"Error peforming read-write operations",e);
    }