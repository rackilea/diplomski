@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @RequestMapping(consumes="application/json")
    @ResponseBody  //required if you want to return POJO (spring will serialize it to response body)
    public void rest() {
       //return POJO, it will be serialized to JSON. or serialize pojo 
       directly and return response with manually set body and headers.
    }

    @RequestMapping(consumes="application/xhtml+xml")
    public void html() {
            //populate model, return string pointing to HTML to View
    }

}