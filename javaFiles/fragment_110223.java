@RequestMapping(value="/test/{tests}", method=RequestMethod.GET)
@ResponseBody
public String test(@PathVariable String tests)
{
     String[] test= tests.split(",");
     return "sth"; 
}