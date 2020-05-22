@RequestMapping("/users")
@Controller
TheWayIDiscourageController(){


@ModelAttribute("securityRoles")
public List<SecurityRoles> getSecurityRoles(){
   return this.securityRoleDao.readAll();
}

@ModelAttribute("salutations")
public List<SecurityRoles> getSalutations(){
   return this.salutationDao.readAll());
}

@ModelAttribute("locales")
public List<SecurityRoles> getLocals(){
   return this.localeDao.readAll();
}

@RequestMapping(params = "form", method = RequestMethod.GET)
public ModelAndView createForm() {
  return new ModelAndView("users/create", "userCreateCommand", new UserCreateCommand());
}

@RequestMapping(method = RequestMethod.POST)
public ModelAndView create(final @Valid UserCreateCommand userCreateCommand, final BindingResult bindingResult) {
...
}

@RequestMapping(value = "/{id}", method = RequestMethod.GET)
public ModelAndView show(@PathVariable("id") final User user) {
...
}
}