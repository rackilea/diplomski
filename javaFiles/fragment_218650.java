//Assuming json holds your JSON as String
   try {
        //Create a JSON array 
        JSONArray jsonArray = new JSONArray(json);

        //Iterate through all the JSON objects
        for(int i=0;i<jsonArray.length();i++){

            //Get ith object
            JSONObject item = jsonArray.getJSONObject(i);

            //Get required data from the object
            String title = (String) item.get("title");
            String location = (String) item.get("location");
            String imageUrl = (String) item.get("imageUrl");
            String pubDate = (String) item.get("pubDate");

            //You can now do anything with the data.
            Log.i("TITLE", title);
            Log.i("LOC", location);
            Log.i("IMG_URL", imageUrl);
            Log.i("P_DATE", pubDate);                           

        }                       

    } catch (JSONException e) {
        Log.i("EXP", "Ooi..! There's an exception.");
        e.printStackTrace();
    }