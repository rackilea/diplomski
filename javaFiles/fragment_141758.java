For(int i=0; JsonArray.length(); i++)
{
   JSONObject jsonObj = JsonArray.getJSONObject(i);
   CourseDetail[i].setCourseName(jsonObj.getString("Name")); 

     ... ...

}