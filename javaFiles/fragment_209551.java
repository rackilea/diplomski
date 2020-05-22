@Controller
@RequestMapping("/test")
public class TestServlet {

@ResponseBody
@RequestMapping("/country", method = RequestMethod.GET, produces = "application/json")
public Map<String, String> getCountry(@PathVariable String latitude, @PathVariable 
String longitude){

final Map<String, String> messageObject = new HashMap<>();
messageObject.put("latitude", latitude);
messageObject.put("longitude", longitude);

//return the html
return messageObject;
}