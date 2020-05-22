JSONObject jobj1 = new JSONObject(result);
String statusCode = jobj1.getString("statusCode");
if (statusCode.equalsIgnoreCase("1001"))
{
 String response = jobj1.getString("response");
 JSONObject jobj2 = new JSONObject(response);
 JSONArray ary=jobj2.getJSONArray("leaveInfo");
 for(int i=0;i<ary.length;i++){
 JSONObject obj=ary.getJSONObject(i);
 String leaveInfo=obj.getString("leaveTypeId");
 System.out.println("leaveInfo: "+leaveInfo);
 } 

 }