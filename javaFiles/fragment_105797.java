public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
  try {
    MessageResources resources = getResources(request);
    ActionErrors errors = super.validate(mapping, request);
    if (getEmpname() == null || getEmpname().length() < 1) {
        errors.add("name", new ActionMessage("error.name.required"));
        throw new Exception(getResources(request).getMessage("error.name.required"));
    }
    return errors;
  } catch (Exception ex) {
    request.setAttribute(Globals.EXCEPTION_KEY, ex);
    return null;
  }
}