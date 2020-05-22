@RequestMapping(value = "/register", method = RequestMethod.POST)
public String registerUser(@ModelAttribute("user") User user, BindingResult result,
                       WebRequest request, Errors errors) {
    User registeredUser = null;
    String originalPassword = user.getPassword();
    if (result.hasErrors() == false) {
        registeredUser = createUserAccount(user, result);
    }
    if (registeredUser == null) {
        return "/register";
    }
    securityService.autologin(registeredUser.getLogin(), originalPassword);

    return "/whiprounds";
}