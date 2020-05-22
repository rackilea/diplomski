try{
    JSONObject yourObject = new JSONObject(yourString);
    int resultCode = yourObject.getInt("success");
    JSONArray innerResult = yourObject.getJSONArray("innerResult");
    //you'll need to iterate through your array then
    List<String> userNames = new ArrayList<>();
    List<String> passwords = new ArrayList<>();
    for(int i =0 ; i < innerResult.length() ; i++){
        JSONObject user = innerResult.getJSONObject(i);
        userNames.add(user.getString("username"));
        passwords.add(user.getString("password"));
    }
}catch(JSONException e){
   e.printStackTrace();
}