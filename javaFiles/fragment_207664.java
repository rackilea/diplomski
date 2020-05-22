HttpClient client = new DefaultHttpClient();
HttpGet request = new HttpGet();
request.setURI(new URI("http://example.com"));
HttpResponse response;
try {
    response = client.execute(request);
    BufferedReader in = new BufferedReader(new InputStreamReader(response
            .getEntity().getContent()));

StringBuilder builder = new StringBuilder();
String line;
while((line=in.readLine())!=null)
{

    builder.append(line);
}
String JSONdata = builder.toString();
Log.i("JsonData",JSONdata);

JSONObject jObject = new JSONObject(JSONdata);


String temp = jObject.getString("imageurl");
Log.e("rid",temp);

} catch (ClientProtocolException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (JSONException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}