JSONObject jsonObject = (JSONObject) obj;
//get responses
JSONArray rsp = (JSONArray)jsonObject.get("responses");
System.out.println(rsp);

//get return value
JSONObject rtvalue = (JSONObject)rsp.get(0);
System.out.println(rtvalue);

//get hexes object
JSONObject hexes = (JSONObject)rtvalue.get("return_value");
System.out.println(hexes);

//get hexes array
JSONArray hexesArray = (JSONArray)hexes.get("hexes");
System.out.println(hexesArray);