String[] parse;
    @PostMapping(value = "/")
    public String payloader(@RequestBody String params ) throws IOException{
        LOGGER.debug("code is hitting");
        String key,key2;
       String value,value2,value3;
        Map<String, String> predictionFeatureMap = mockconfig.getPredictionFeatureMap();
        if(parse.length!=18) {

            key = "Not_enough_parameters";
            value = predictionFeatureMap.get(key);
            Map<String,Object> resultJsonObj = new Gson().fromJson(value, Map.class);
            key2 = "errorMessage";
            value2 = (String) resultJsonObj.get(key2);
            value3 = value2.substring(0,61) +parse.length+value2.substring(62);
            resultJsonObj.replace(key2, value3);
            String updatedResponse = new Gson().toJson(resultJsonObj,Map.class);  
            value = updatedResponse;

            }
        else {
            key = params;
            value = predictionFeatureMap.get(key);
        }
        return value;