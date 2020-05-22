@Controller
public class FoobarController {

    @RequestMapping("/path")
    @ResponseBody
    public String getContent(@RequestHeader("User-Agent") String userAgent,
                             HttpServletResponse response) {
        if (isIE(userAgent)) {
            response.setContentType("text/plain");
        } else {
            response.setContentType("text/json");
        }
        ...
        return "{\"key\":\"value\"}";
    }
}