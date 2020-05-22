@RequestMapping(value = "/{name}", method = RequestMethod.POST)
public String submitFormAction(@PathVariable("name") final String name, final WebRequest request, final Model model) {
    final Object bean = registry.lookup(name);
    final Validator validator = validatorRegistry.lookup(name);
    final WebRequestDataBinder binder = new WebRequestDataBinder(bean, "bean");

    binder.setValidator(validator);
    binder.validate();
    binder.bind(request);

    final BindingResult result = binder.getBindingResult();

    if (result.hasErrors()) {
        model.addAttribute("name", name);
        model.addAllAttributes(result.getModel());

        return "form";
    }

    return "redirect:/" + name;
}