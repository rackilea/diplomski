public JSONObject lastSub(String username) throws ClientProtocolException, IOException, JSONException {
StringBuilder url = new StringBuilder(URL);
url.append(username);
HttpGet get = new HttpGet(url.toString());

HttpResponse r = client.execute(get);
//httpStuff.setText("xxx");
int status = r.getStatusLine().getStatusCode();
if(status == 200) {
    HttpEntity e = r.getEntity();
    String data = EntityUtils.toString(e);
    JSONObject last = new JSONObject(data).getJSONArray("result").getJSONObject(0);

    return last;
}
else {
    Toast.makeText(Http.this, "error", Toast.LENGTH_SHORT);
    return null;

}
}