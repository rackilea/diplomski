private String getResponse(){

JSONObject json = new JSONObject();
try {

    json.put("Username", "John");
    json.put("Message", "Hellow");
} catch (JSONException e) {

    e.printStackTrace();
}
return json.toString();
}

private void receiver(){
try {
    JSONObject response = new JSONObject(getResponse());
    String username = response.getString("Username");
    String message = response.getString("Message");
    System.out.println(String.format("%s : %s", username,message));

} catch (JSONException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

}