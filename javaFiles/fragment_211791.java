@Controller
public class ErrorController {
    @RequestMapping(value = "/error" method = {RequestMethod.GET, RequestMethod.POST})
    public String error(@RequestParam(value = "err", required = false) Integer paramErrorCode, Locale locale,
            ModelMap model, HttpServletRequest httpRequest) {
         // Do something   
     }