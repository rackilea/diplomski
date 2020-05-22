JSONArray jr = new JSONArray("myjsonstring");
for(int i =0;i<jr.length();i++)
{
   JSONObject jb = (JSONObject)jr.get(i);
   String id = jb.getString("StudentID");
   Log.i(".......",id);
   // Similar for other ChildName and ClassName
   // use getBoolean for attendance 
}