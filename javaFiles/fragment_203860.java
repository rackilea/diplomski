@Controller
@SessionAttributes({"changePasswordForm"})
public class MyController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
       binder.setValidator(new ChangePasswordFormValidator());
    }

    @ModelAttribute("changePasswordForm")
    public ChangePasswordForm createChangePasswordForm() {
      ...
    }


    @RequestMapping(...)
    public ModelAndView controllerMethod(
          @Valid @ModelAttribute changePasswordForm ChangePasswordForm) {
      ...
    }
}