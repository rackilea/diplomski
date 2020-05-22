private void parseJSON(String data1) throws Exception,NullPointerException, JSONException 
{
    try 
    {
        JSONObject jObj = new JSONObject(data1);
        JSONArray jObjArr = jObj.optJSONArray("data");
        int lon = jObjArr.length();


        for (int i = 0; i < lon; i++) 
        {
            JSONObject tmp = jObjArr.optJSONObject(i);

            String temp_image =  tmp.getString("picture");                          String temp_fname = tmp.getString("first_name");

            String temp_lname = tmp.getString("last_name");

            String temp_loc = null;

            JSONObject loc = tmp.getJSONObject("location");
            temp_loc = loc.getString("name");


        }
    } 
    catch (Exception e) 
    {
        Log.i("Exception1 is Here>> ", e.toString());
        e.printStackTrace();
    }
}