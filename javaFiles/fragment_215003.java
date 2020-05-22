public class BaseController {
    @ExceptionHandler(Throwable.class)
    public String handleException(Throwable t) {
        return "redirect:/errorPages/500.jsp";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Throwable t) {
        return "redirect:/errorPages/error.jsp";
    }
}

@Controller
@RequestMapping(value = "/admin/store")
public class AdminController extends BaseController
{
    @RequestMapping(...)
    //Some method

    @RequestMapping(...)
    //Another method
}