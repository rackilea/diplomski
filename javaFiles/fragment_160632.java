public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException{
    IronRunId Id = new IronRunId("RunObject", "Runid1", 4);
    Map<String, String> aspects = new HashMap<String, String>();
    aspects.put("aspectskey1", "aspectsValue1");
    aspects.put("aspectskey2", "aspectsValue2");
    aspects.put("aspectskey3", "aspectsValue3");
    String anotherString = "anotherString";
    long time = 1L;

    Wrapper objectWrapper = new Wrapper();
    ObjectMapper objectMapper = new ObjectMapper();

    objectWrapper.setIronRunId(Id);
    objectWrapper.setTime(time);
    objectWrapper.setAnotherString(anotherString);
    objectWrapper.setAspects(aspects);

    Map<String, Wrapper> map = new HashMap<String, Wrapper>();
    map.put("theWrapper", objectWrapper);
    String json = objectMapper.writeValueAsString(map);

    Map<String, Wrapper> map1 = objectMapper.readValue(json, new TypeReference<Map<String, Wrapper>>() {});
    Wrapper wrapper = map1.get("theWrapper");

    System.out.println("run id : " +  wrapper.getIronRunId().toString());
    System.out.println("time : " + wrapper.getTime());
    System.out.println("aspects : " + wrapper.getAspects().toString());
    System.out.println("anotherString : " + wrapper.getAnotherString());
}