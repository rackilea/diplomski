@RequestMapping(
    value = "/process", 
    method = RequestMethod.POST,
    consumes = "text/plain")
public void process(@RequestBody String payload) throws Exception {

  System.out.println(payload);

}