@RequestMapping( method = RequestMethod.GET,headers="Accept=application/json")
 public @ResponseBody Map printHello(ModelMap model) {
     Map<String,String> json = new HashMap<String,String>();
     json.put("name", "abcd");
      return json;
 }