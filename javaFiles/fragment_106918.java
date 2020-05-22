JSONObject jsonObject = new JSONObject("Your JSON STRING HERE");

JSONArray  jsonArray =jsonObject.getJSONArray("item");

 for (int i = 0; i < jsonArray.length(); i++) {
    JSONObject jsonObjectitem=
                           jsonArray.getJSONObject(i);                                                                            

  // get title or link here
     String strtitle=jsonObjectitem.getString("title");
      //....get other values in same way 

   // get media:content json object
  JSONObject jsonObjectmediacontent = 
                       jsonObjectitem.getJSONObject("media:content");

   // get url,medium,...

     String strurl=jsonObjectmediacontent.getString("-url"); 
     //....get other values in same way                                   
 }