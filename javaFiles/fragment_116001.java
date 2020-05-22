@RequestMapping(value = "/user", method = RequestMethod.POST)
public String processedForm(@ModelAttribute("user") User user, BindingResult result,
                            ModelMap model,HttpSession session) {
    if (result.hasErrors()) {
        return "form/userForm";
    }
    session.setAttribute("user",user);
    ArrayList<String> p = new ArrayList<String>();
    p.add("add_user");
    p.add("delete_user");
    model.addAttribute("permissions", p);
    model.addAttribute("user", user);
    return "form/permissionForm";
}
@RequestMapping(value = "/show", method = RequestMethod.POST)
public String show(@ModelAttribute("user") User user, BindingResult result,HttpSession session) {
    User userInSession = (User)session.getAttribute("user");
    userInSession.setPermissions(user.getPermissions());

    if (result.hasErrors()) {
        System.out.println("Error");
        return "show";
    } else {
        System.out.println(userInSession);
        return "show";
    }
}