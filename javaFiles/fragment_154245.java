JSONObject postData = new JSONObject();
    JSONObject userJson=new JSONObject();
    try {
        userJson.put("country","IN");
        userJson.put("number","9620494812");
    } catch (JSONException e) {
        e.printStackTrace();
    }
    try {
        postData.put("username" , userJson);
        postData.put("password" , "119209");

    } catch (JSONException e) {
        e.printStackTrace();
    }