private boolean sendData(ArrayList<NameValuePair> data) {
    try {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(YOUR_URL);
        httppost.setEntity(new UrlEncodedFormEntity(data));
        HttpResponse response = httpclient.execute(httppost);
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}