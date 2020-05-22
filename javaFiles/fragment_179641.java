@Controller
@RequestMapping("/path/to/your/web/service")
public class WebServiceController{

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> handleLogin(@RequestBody User user){
         //user contains data passed from UI form. Check it against your repository(database ? )

    }
}