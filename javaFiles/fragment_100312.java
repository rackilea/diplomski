@Controller
public class ViewController {

    @RequestMapping(value = "**/")
    public String all(HttpServletRequest request) {     
        String path = request.getRequestURI().replace(request.getContextPath(),"");
        return path.endsWith("/") ? path +"index" : path;
    }

}