public class AccountController extends MultiActionController {
    public ModelAndView listAccounts() {
        // your code
        return new ModelAndView("listAccounts.bean", "msg", "As you  want")
    }
}