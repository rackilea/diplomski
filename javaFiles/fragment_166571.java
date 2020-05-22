String finalJSON =buffer.toString();;
    JSONObject parentObject = null;
    try {
        parentObject = new JSONObject(finalJSON);
        JSONObject objectA_Color=parentObject.getJSONObject("response").getJSONObject("items").getJSONObject("A Color Similar to Slate");

       int  value=objectA_Color.getInt("value");
    } catch (JSONException e) {
        e.printStackTrace();
    }