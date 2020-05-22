@Override
protected String doInBackground(String... uri) {
    HttpClient httpclient = new DefaultHttpClient();
    HttpResponse response;
    String responseString = null;
    try {
        response = httpclient.execute(new HttpGet(uri[0]));
        StatusLine statusLine = response.getStatusLine();
        if(statusLine.getStatusCode() == HttpStatus.SC_OK){
            responseString = EntityUtils.toString(response.getEntity()); // content will be consume only once
            Gson gson = new Gson();
            Holder response1 = gson.fromJson(responseString, Holder.class);
        } else{
            //Closes the connection.
            response.getEntity().getContent().close();
            throw new IOException(statusLine.getReasonPhrase());
        }
    } catch (ClientProtocolException e) {
        //TODO Handle problems..\
        progressDialog.hide();
    } catch (IOException e) {
        //TODO Handle problems..
        progressDialog.hide();
    }
    return responseString;
}