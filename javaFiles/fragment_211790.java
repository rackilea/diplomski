@Controller
public class ErrorController {
    @RequestMapping("/error")
    public String error(@RequestParam(value = "err", required = false) Integer paramErrorCode, Locale locale,
            ModelMap model, HttpServletRequest httpRequest) {
         // Do something   
     }