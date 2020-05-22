public class BaseController {

    @ModelAttribute("user")
    public User getUser(HttpServletRequest request) {
        return (User)request.getAttribute("user");
    }
}