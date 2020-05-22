JSONArray imageArray = hist.getJSONArray("image");
int len = imageArray.length();
ArrayList<String> imageLinks = new ArrayList<String>();
for (int i = 0; i < len; i++) {
    boolean isObject = false;
    try {
        JSONArray obj = imageArray.getJSONObject(i);
        // obj is a JSON object
        isObject = true;
    } catch (JSONException ex) {
        // ignore
    }
    if (!isObject ) {
        // Element at index i was not a JSON object, might be a String
        try {
            String strVal = imageArray.getString(i);
            imageLinks.add(strVal);
        } catch (JSONException ex) {
            // ignore
        }
    }
}
int numImageLinks = imageLinks.size();