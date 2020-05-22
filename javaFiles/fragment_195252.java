public static void main(String[] args) {

    Gson gson = new Gson();
    Map<String, Object> data = gson.fromJson("{\"Jar_serviceid\": \"service_v1\",\"Jar_version\": \"1.0\",\"ServiceId\": \"srv_v1\",\"ServiceState\": \"Enable\",\"ServiceVersion\": \"v1\",\"LicenseRequired\": false,\"ServiceURL\": null}", Map.class);
    Map<String, Object> newValues = gson.fromJson("{\"Include\":[{\"Jar_serviceid\":\"service_v1\",\"Jar_version\":\"1.0\",\"ServiceState\":\"null\"}],\"Exclude\":\"rtm_v2\"}", Map.class);

    if(null != newValues
            && newValues.containsKey("Include") 
            && newValues.get("Include") instanceof List){
        Map<String,Object> firstValue = ((List<Map>) newValues.get("Include")).get(0);
        if(null == data){
            data = new HashMap<>(firstValue);
        }else{
            for(String key : firstValue.keySet()){
                data.put(key, firstValue.get(key));
            }
        }
    }

    System.out.println(gson.toJson(data));
}