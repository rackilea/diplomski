public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    ActionErrors errors = super.validate(mapping, request);

    if (idNumber.length() < 1 && packageNumber .length() < 1) {
        errors.add("emptyForm",
                new ActionError("error.form.empty", "emptyForm"));
    }

    return errors;