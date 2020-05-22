try {
    JSONObject result = new JSONObject(response);

    if(data.has("ValidateLoginResult"){
        JSONArray array = result.getJSONArray("ValidateLoginResult");

        for (int i = 0; i < array.length(); i++) {
        JSONObject obj = array.getJSONObject(i);
            String ErrorMessage= ""+obj.getString("ErrorMessage");
            String PropertyName= ""+obj.getString("PropertyName");
        }
    }

} catch (JSONException e) {
    e.printStackTrace();
}