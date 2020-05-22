// to use the necessary @SerializedName annotations
String classNameJson = new Gson().toJson(className);    // {"field_a": "fjdksljf", "field_b" : "jfsljd", ... etc.}
JSONObject json = new JSONObject();
try {
     // must make this a new JSONObject or else it will handle classNameJson as a string and append unnecessary quotes
     json.put("class_name", new JSONObject(classNameJson));    
} catch (JSONException e) {
     // handle the error
}
String result = json.toString();