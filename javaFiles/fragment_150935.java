//create a jsonObject
JSONObject jsonObject = new JSONObject("{ \"locations\" ...<snipped>... ] }");

//run some getters until you get to the address_component
JSONArray locations = (JSONArray)jsonObject.get("locations");
JSONObject location = (JSONObject)locations.get(0); // get the first location
JSONObject geoCodeResponse = (JSONObject)location.get("GeocodeResponse");
JSONObject result = (JSONObject)geoCodeResponse.get("result");
JSONArray addressArray = (JSONArray)result.get("address_component");

//print out the long_name from the address
JSONObject address = (JSONObject)addressArray.get(0);
String longName = (String)address.get("long_name");
System.out.println(longName); //prints Tchibanga