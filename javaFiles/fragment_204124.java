String str = "YOUR_JSON_RESPONSE";
String array[] = str.split("\\[\\{");// 
try {
     JSONArray jsonArray=new JSONArray("[{" + array[2]));
} catch (JSONException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}