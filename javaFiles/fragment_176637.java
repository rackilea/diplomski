@Controller
public class RobotsController {

    @RequestMapping(value = "/robots.txt", method = RequestMethod.GET)
    public String getRobots(HttpServletRequest request) {
        return (Arrays.asList("mysite.com", "www.mysite.com").contains(request.getServerName())) ?
                "robotsAllowed" : "robotsDisallowed";
    }
}