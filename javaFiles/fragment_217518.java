try {
    // Fist request! With your tag and username and more
    HttpResponse response = httpClient.execute(httpPost);

    // writing response to log
    Log.d("Http Response:", response.toString());
    // try to parse it to json
    JSONObject json = new JSONObject(response.toString());
    // do what ever you like...
} catch (ClientProtocolException e) {
    // writing exception to log
    e.printStackTrace();
    response = response+"ClientProtocolException";
} catch (IOException e) {
    // writing exception to log
    e.printStackTrace();
    response = response+"IOException";
}