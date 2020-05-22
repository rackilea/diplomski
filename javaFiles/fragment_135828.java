private String getCredentials() {
    String u=user.getText().toString();
    String p=password.getText().toString();

    return(Base64.encodeBytes((u+":"+p).getBytes()));
}

private void updateStatus() {
    try {
        String s=status.getText().toString();

        HttpPost post=new HttpPost("https://identi.ca/api/statuses/update.json");

        post.addHeader("Authorization",
                                     "Basic "+getCredentials());

        List<NameValuePair> form=new ArrayList<NameValuePair>();

        form.add(new BasicNameValuePair("status", s));

        post.setEntity(new UrlEncodedFormEntity(form, HTTP.UTF_8));

        ResponseHandler<String> responseHandler=new BasicResponseHandler();
        String responseBody=client.execute(post, responseHandler);
        JSONObject response=new JSONObject(responseBody);
    }
    catch (Throwable t) {
        Log.e("Patchy", "Exception in updateStatus()", t);
        goBlooey(t);
    }
}