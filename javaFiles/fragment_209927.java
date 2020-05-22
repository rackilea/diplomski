@Autowired
private PersonValidator personValidator;

@RequestMapping(value="person/form", method = RequestMethod.GET)
public ModelAndView form() {
    // Instance of binding object
    Person person = new Person();

    // Create ModelAndView which displays personForm view
    ModelAndView mav = new ModelAndView("person/form");
    // Put our binding object in the model
    mav.getModel().put("person", person);

    return mav;
}

@RequestMapping(value="person/form", method = RequestMethod.POST)
public String save(@ModelAttribute Person person, BindingResult errors, Model model) {
    // Call our custom validator and put errors into BindingResult
    personValidator.validate(person, errors);

    // If we have validation errors
    if (errors.hasErrors()) {
        // Show form with errors
        return "person/form";
    }

    // Otherwise show some success page
    return "person/success";
 }