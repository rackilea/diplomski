FacesMessage msg = new FacesMessage(
        FacesMessage.SEVERITY_ERROR,
        "The old password was not entered correctly.",
        ""
);
context.addMessage(comp.getClientId(context), msg);
throw new ValidatorException(msg);