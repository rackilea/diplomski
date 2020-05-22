@RequestMapping("/users")
@Controller
TheWayIPreferController() {

@RequestMapping(params = "form", method = RequestMethod.GET)
public ModelAndView createForm() {
  ModelMap uiModel = new ModelMap();
  uiModel.addAttribute("userCreateCommand", new UserCreateCommand());
  uiModel.addAttribute("securityRoles", this.securityRoleDao.readAll()));
  uiModel.addAttribute("salutations", this.salutationDao.readAll()));
  uiModel.addAttribute("locales", this.localeDao.readAll());
  return new ModelAndView("users/create", uiModel);
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