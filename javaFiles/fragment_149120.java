public static void main(String[] args) throws JSONException{
    // TODO Auto-generated method stub

     String JSON = "{\"IP\":{\"string\":\"1.2.3.4\"},\"UrlParameters\":{\"map\":{\"pw\":\"36\",\"mu\":\"www.abc.com\"}}}";

     JSONObject jsonObject = new JSONObject(JSON);
     System.out.println("Full JSON String: "+jsonObject);

     JSONObject urlParametersMap = jsonObject.getJSONObject("UrlParameters").getJSONObject("map");
     System.out.println("mu: "+urlParametersMap.getString("mu"));
     System.out.println("pw: "+urlParametersMap.getString("pw"));
}