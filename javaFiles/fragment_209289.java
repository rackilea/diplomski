@Controller
public class Controller1 {

    @RequestMapping(value = "/signup", method= RequestMethod.GET)
    public String signupForm(@ModelAttribute("signup") SignUpForm form) {
        return "/signup";
    }

    @RequestMapping(value = "/signup", method= RequestMethod.POST)
    public String signupSubmit(@ModelAttribute("signup") SignUpForm form, RedirectAttributes redirectAttributes) {
        //validate form first -> check bindingResult documentation

        //do what you need with your form object

        redirectAttributes.addFlashAttribute("email", form.getEmail());
        return "redirect:/result";
    }

    @RequestMapping(value = "/result", method= RequestMethod.GET)
    public String result() {
        return "/result";
    }

}