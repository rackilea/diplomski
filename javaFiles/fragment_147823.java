@RequestMapping(value ="/addUser", method = RequestMethod.POST)
public String addUser(@ModelAttribute("user") @Valid User user, BindingResult result) {

    if(result.hasErrors()) {
        return "register";
    }
    String hashPassword = new PasswordHashProcessor().getHashPassword(user.getPassword());
    user.setPassword(hashPassword);
    daoService.addUser(user);
    return "redirect:/getUsers";
}