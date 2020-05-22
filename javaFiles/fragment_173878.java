@ExceptionHandler(value=SignupFormException.class)
public String handle(Model model, HttpServletRequest req) {
    Account account = req.getSession().getAttribute("account");
    req.getSession().removeAttribute("account"); //Important, you don't want to keep useless objects in your session
    model.addAttriute(account.getUsername());
    return "redirect:/signup";
}