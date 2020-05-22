@RequestMapping(method = RequestMethod.POST,params = {"dynamicScenario"})
@ResponseBody
public Map<String, Object> getDynamicScenarioData(@RequestParam Map<String, String> map) throws JsonParseException, JsonMappingException, IOException
 {
     ObjectMapper mapper = new ObjectMapper();

     @SuppressWarnings("unchecked")
     Map<String,Object> queryParameters = mapper.readValue(map.get("parameters") , Map.class);

     Map<String, Object> getData = service.runDynamicScenario(queryParameters, map.get("queryString"));

     return getData;
}