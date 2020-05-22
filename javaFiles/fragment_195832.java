@RequestMapping(value = "{entityName}/create", method = RequestMethod.GET)
public String create(@PathVariable("entityName") String entityName, @ModelAttribute("entity") BaseEntity entity, BindingResult errors) {
  LOG.debug("Displaying create page for entity named: [{}]", entityName);
  return handlerFactory.getHandler(entityName).getCreateView();
}

@RequestMapping(value = "{entityName}/create", method = RequestMethod.POST)
public String save(@PathVariable("entityName") String entityName, @ModelAttribute("entity") BaseEntity entity, BindingResult errors) {
  LOG.debug("Saving entity of type {}", entityName);
  CrudHandler handler = handlerFactory.getHandler(entityName);
  handler.getCreateValidator().validate(entity, errors);
  if (errors.hasErrors()) {
    return create(entityName, entity, errors);
  }
  handler.preSave(entity);
  handler.getService().save(entity);
  return "redirect:" + DASHBOARD_URL;
}