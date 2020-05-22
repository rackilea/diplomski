public void actionPerformed(ActionEvent ae) {
    String uname = text1.getText();
    String pwd = text2.getText();

    HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost(
            "http://localhost:8089/SwingChat/LoginAction?uname=" + uname
                    + "&pwd=" + pwd);
    try {
        // Add your data
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("uname", uname));
        nameValuePairs.add(new BasicNameValuePair("pwd", pwd));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        // executing the POST request
        HttpResponse rsp = client.execute(post);

        // reading response data
        HttpEntity entity = rsp.getEntity();
        InputStream inputStream = entity.getContent();
        String response = convertStreamToString(inputStream);
        System.out.println("Response from server : " + response);
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

}

private static String convertStreamToString(InputStream is) {

    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();

    String line = null;
    try {
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return sb.toString();
}