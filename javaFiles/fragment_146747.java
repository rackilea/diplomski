try {

       JSONArray  jsonArray = new JSONArray(res);
       List<ShreyPojo> pojoList = new ArrayList<>();

       for(int i = 0; i < jsonArray.length(); i++)
       {
          //JSONObject jsonObject = jsonArray.getJSONObject(i);
            String jsonObject = jsonArray.getString(i);

          ShreyPojo obj = mapper.readValue(jsonObject,ShreyPojo.class); 

           pojoList.add(obj);
       }

   // Use ShreyPojo objects as per requirement

 } catch (Exception e)
 {
    Log.w("Exception = ","" + e.toString());
 }