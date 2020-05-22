@RequestMapping(method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> getDynamicScenarioData(@RequestBody Map<String,Object> queryParameters) throws JsonParseException, JsonMappingException, IOException
 {
     Map<String, Object> getData = service.runDynamicScenario(queryParameters, /* find a better way to pass this map.get("queryString") */);

     return getData;
}