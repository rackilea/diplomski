@RequestMapping(value = "/updatePerson", method = RequestMethod.GET)
public String showPerson(Model model) {
    PersonChangeRequest person = new PersonChangeRequest();
    person.setAge(23);
    model.addAttribute("person", person);

    return "updatePerson";
}

@RequestMapping(value = "/updatePerson", method = RequestMethod.POST)
public String alterPerson(@ModelAttribute PersonChangeRequest personChangeRequest) {
    Person person = findPersonToChange(personChangeRequest);
    person.setAge(personChangeRequest.getAge());
}