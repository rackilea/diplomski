// Making HTTP Request
try {
    // Fist request! With your tag and username and more
    HttpResponse response = httpClient.execute(httpPost);

    // writing response to log
    Log.d("Http Response:", response.toString());
} catch (ClientProtocolException e) {
    // writing exception to log
    e.printStackTrace();
    response = response+"ClientProtocolException";
} catch (IOException e) {
    // writing exception to log
    e.printStackTrace();
    response = response+"IOException";
} 

try{
    // second request! No tag, username...
    JSONObject json = readJsonFromUrl("http://mysite/");
    System.out.println(json.toString());
    System.out.println(json.get("id"));
} catch(IOException e) {
    e.printStackTrace();
} catch (JSONException e) {
    e.printStackTrace();
}