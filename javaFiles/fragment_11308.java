public String intercept(ActionInvocation invocation) throws Exception {
    Object action = invocation.getAction();
    if (action instanceof ValidationAware) {
        ValidationAware validationAware = (ValidationAware) action;
        validationAware.addFieldError("field", "field error");
        validationAware.addActionMessage("action message");
        validationAware.addActionError("action error");
    }
    return invocation.invoke();
}