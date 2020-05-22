@RequestMapping(
    value = "/process", 
    method = RequestMethod.POST)
public void process(@RequestBody Map<String, Object> payload) 
    throws Exception {

  System.out.println(payload);

}