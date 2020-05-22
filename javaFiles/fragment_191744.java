@RequestMapping("/login")
public String login(User user,
    BindingResult result, Model model, HttpServletRequest request,
    HttpServletResponse response) {

loginFormValidator.validate(user, result);

if(Errors in `result`)
    populateAttributes(user, null);
    return "home";

// Authentication Logic
request.getSession().setAttribute("s_user_obj", some_variable);
populateAttributes(model, user, null);
return "home";