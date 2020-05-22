// If our value is valid and not empty or empty w/ validate empty fields enabled, call all validators
if (isValid() && (!isEmpty(newValue) || validateEmptyFields(context))) {
    if (validators != null) {
        Validator[] validators = this.validators.asArray(Validator.class);
        for (Validator validator : validators) {
            try {
                validator.validate(context, this, newValue);
            }
            catch (ValidatorException ve) {
                // If the validator throws an exception, we're
                // invalid, and we need to add a message
                setValid(false);
                FacesMessage message;
                String validatorMessageString = getValidatorMessage();

                if (null != validatorMessageString) {
                    message =
                          new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                           validatorMessageString,
                                           validatorMessageString);
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                } else {
                    Collection<FacesMessage> messages = ve.getFacesMessages();
                    if (null != messages) {
                        message = null;
                        String cid = getClientId(context);
                        for (FacesMessage m : messages) {
/* Here --> */              context.addMessage(cid, m);
                        }
                    } else {
                        message = ve.getFacesMessage();
                    }
                }
                if (message != null) {
/* And here --> */  context.addMessage(getClientId(context), message); 
                }
            }
        }
    }
}