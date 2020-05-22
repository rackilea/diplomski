@RequestMapping(method = RequestMethod.PUT, value = "/workers/{id}")
public ModelAndView update(@PathVariable final Long id, @Valid Worker entity, Errors errors, NativeWebRequest request) {
    ModelAndView model = new ModelAndView();
    entity.setId(id);
    if (errors.hasErrors()) {
        model.addObject("entity", entity);
        model.addObject("errors", errors);
        model.setViewName(names.provideViewName(Pages.EDIT));
    } else {
        System.out.println("upd-done");
        service.update(entity);
        model.setViewName("redirect:/workers/" + entity.getId());
        model.addObject(entity);
    }
    return model;
}