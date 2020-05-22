// the constructor should have at least these parameters
// to be passed onto super()
public Utf8JsonRequest(int method,
                       String url,
                       String requestBody,
                       Response.Listener<JSONObject> listener,
                       Response.ErrorListener errorListener) {
    super(method, url, requestBody, listener, errorListener);

    // you can initialize other stuff if you wish
}