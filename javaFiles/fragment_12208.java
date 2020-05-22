@Controller
public class CustomErrorController implements ErrorController  
    @RequestMapping("/error") 
    public String handleError(HttpServletRequest request, Model model) { 
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}