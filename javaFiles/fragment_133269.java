JSONObject jsonObject=new JSONObject(value);
String strType="";
if(jsonObject.has("notification-action")){
   JSONObject jsonObjectnotification=jsonObject.optJSONObject
                                         (""notification-action"");
   if(jsonObjectnotification.has("type")){
      strType=jsonObjectnotification.optString("type");
   }
}