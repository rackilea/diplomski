public static Map<String,String> parse(JSONObject json , Map<String,String> out) throws JSONException{
    Iterator<String> keys = json.keys();
    while(keys.hasNext()){
        String key = keys.next();
        String val = null;
        try{
             JSONObject value = json.getJSONObject(key);
             parse(value,out);
        }catch(Exception e){
            val = json.getString(key);
        }

        if(val != null){
            out.put(key,val);
        }
    }
    return out;
}

 public static void main(String[] args) throws JSONException {

    String json = "{'ipinfo': {'ip_address': '131.208.128.15','ip_type': 'Mapped','Location': {'continent': 'north america','latitude': 30.1,'longitude': -81.714,'CountryData': {'country': 'united states','country_code': 'us'},'region': 'southeast','StateData': {'state': 'florida','state_code': 'fl'},'CityData': {'city': 'fleming island','postal_code': '32003','time_zone': -5}}}}";

    JSONObject object = new JSONObject(json);

    JSONObject info = object.getJSONObject("ipinfo");

    Map<String,String> out = new HashMap<String, String>();

    parse(info,out);

    String latitude = out.get("latitude");
    String longitude = out.get("longitude");
    String city = out.get("city");
    String state = out.get("state");
    String country = out.get("country");
    String postal = out.get("postal_code");

    System.out.println("Latitude : " + latitude + " LongiTude : " + longitude + " City : "+city + " State : "+ state + " Country : "+country+" postal "+postal);

    System.out.println("ALL VALUE " + out);

}