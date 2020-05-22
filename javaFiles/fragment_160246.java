public static boolean checkIfOnline(String channel) throws JSONException, IOException {
    String channerUrl = "https://api.dailymotion.com/video/x3p6d9r?fields=onair";

    String jsonText = readFromUrl(channerUrl);// reads text from URL

    JSONObject json = new JSONObject(jsonText); // You create a json object from your string jsonText
    if(json.has("onair")) { // just a simple test to check the node that you need existe
        boolean value = json.getBoolean("onair"); // In the url that you gave onair value is boolean type 
        return value;
    }
    return false;
}