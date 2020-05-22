JSONArray jarray = new JSONArray("Your JSON String Here");

for (int i=0; i < jarray.length(); i++)
{
  JSONObject oneObject = jArray.getJSONObject(i);
  // Pulling items from the array
   String oneObjectsid = oneObject.getString("id");
   String oneObjectsap = oneObject.getString("ap");
   String oneObjectsstatus = oneObject.getString("status");
   String oneObjectsname = oneObject.getString("name");
   //your rest code here...
}