private void populateAttributes(Model model, User loginUser, User signupUser){
    if (loginUser==null) loginUser = new User();
    if (singupUser==null) singupUser = new User();
    model.addAttribute("loginUser", loginUser);
    model.addAttribute("signupUser", signupUser);
}