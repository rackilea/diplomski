@RequestMapping(value="/login", method= { RequestMethod.POST } )
public String redirect(@ModelAttribute("LoginForm") @Valid LoginForm loginForm,  BindingResult bindingResult, Model model)  {
    if(bindingResult.hasErrors()){
        return "home";
    }

    model.addAttribute("name", loginForm.getName());
    return "loginPage";
}