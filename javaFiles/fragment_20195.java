String url = "http://www.website.net/folder/connect.php";
HttpPost method = new HttpPost(url);
HttpClient httpClient = new DefaultHttpClient();
List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
formparams.add(new BasicNameValuePair("email", email.toString()));
formparams.add(new BasicNameValuePair("password", password.toString()));
formparams.add(new BasicNameValuePair("reporter", senderName));
formparams.add(new BasicNameValuePair("reported", targetName));
formparams.add(new BasicNameValuePair("reason", reasonString));
UrlEncodedFormEntity entity = null;
try {
    entity = new UrlEncodedFormEntity(formparams, "UTF-8");
} catch (UnsupportedEncodingException e) {
    e.printStackTrace();
}
method.setEntity(entity);
HttpResponse httpResponse = httpClient.execute(method);