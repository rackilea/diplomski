@RequestMapping("/signup")
public String signUpUser(User user,
    BindingResult result, Model model) {
    populateAttributes(model, null, user);
    return "home"
}