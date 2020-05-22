try {
    ...
    JSONObject jObj = new JSONObject(stringaRis);
    ...
} catch (JSONException e) {
    Log.e("MYAPP", "unexpected JSON exception", e);
    // Do something to recover ... or kill the app.
}