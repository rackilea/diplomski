@RequestMapping(value="/user", method=RequestMethod.POST)
public createUser(Model model, @Valid @ModelAttribute("user") User user, BindingResult result){
    if (result.hasErrors()){
      // do something
    }
    else {
      // do something else
    }
}