JSONArray jsPoints = new JSONArray();

for(int i = 0; i < points.length; i++)
{       
 JSONObject js = null;

try 
{
   js = new JSONObject();  
   js.put("id",points[i]._id);
   js.put("calification",points[i]._calification);
   js.put("comment",points[i]._comment);
   js.put("gps",points[i]._coords);
   js.put("X",points[i]._X);
   js.put("Y",points[i]._Y);
} 
catch (JSONException e) 
{                               
   e.printStackTrace();
}
  if(js!=null)
    jsPoints.put(js);