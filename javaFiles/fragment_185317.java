@RequestMapping(value="/user", method=RequestMethod.POST)
    public createUser(Model model, @ModelAttribute("user") User user, BindingResult result){
        UserValidator userValidator = new UserValidator();
        userValidator.validate(user, result);

        if (result.hasErrors()){
          // do something
        }
        else {
          // do something else
        }
}