public void registerAPI(String apiName, double[] apiValues) {
    if(!averagePerAPI.containsKey(apiName)) {
        APIData data = new APIData();
        data.addValues(apiValues)
        averagePerAPI.put(apiName, data);
    } else {
        averagePerAPI.get(apiName).addValues(apiValues);
    }
}