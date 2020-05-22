@RequestMapping(value = "/{login}/edit", method = RequestMethod.POST)
public ModelAndView updateUser(@PathVariable("login") final String login, @ModelAttribute(MODEL_USER) final Person person, BindingResult bindingResult,  final Model model) {
    Person repositoryPerson = personRepository.findPersonByLogin(login);

    repositoryPerson = repositoryPerson.updateWith(person);
    manageUserService.updatePerson(repositoryPerson);

    model.asMap().clear();
    return new ModelAndView("redirect:" + URL_USERS_OVERVIEW, MODEL, model);
}