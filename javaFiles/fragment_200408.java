JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
    if(null!=jsonObject.get("hits"))
    {
        System.out.println("Inside IF...");
        JSONArray ja = (JSONArray) jsonObject.get("hits");
        for(int i=0;i<ja.size() ; i++)
        {
            System.out.println("Inside FOR...");
            JSONObject tempJsonObj = (JSONObject) ja.get(i);
            System.out.println(tempJsonObj.get("name").toString());
            System.out.println(tempJsonObj.get("results").toString());
      JSONArray innerarray = (JSONArray) tempJsonObj.get("results");
    for(int i=0;i<innerarray.size() ; i++)
    {
     JSONObject tempJsoninnerObj = (JSONObject) innerarray.get(i);
            System.out.println(tempJsoninnerObj.get("count").toString());
    }


        }
    }