JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonFormattedVehicleResponse);
JSONArray vehicles = (JSONArray) jsonObject.get("vehicle");
for(Object vehicle : vehicles) {
    JSONObject vehicleJSON = (JSONObject) vehicle;
    if(vehicleJSON.containsKey("subValue")) {
        JSONObject subJSON = (JSONObject) vehicleJSON.get("subValue");
        //do stuff
    }
}