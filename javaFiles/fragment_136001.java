public void getJson() {
    String json = getJSONFromURLConnection("https://api.clashofclans.com/v1/clans?name=illuminati");
    if (json != null) {
        Log.i("JSON", json.toString());
    }
}