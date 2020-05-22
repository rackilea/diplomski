public String intercept(ActionInvocation invocation) throws Exception {
    final ActionContext context = invocation.getInvocationContext();
    Map<String,Object> parameters = (Map<String,Object>)context.get(ActionContext.PARAMETERS);

    Map<String, Object> parametersCopy = new HashMap<String, Object>();
    parametersCopy.putAll(parameters);
    parametersCopy.put("myParam", "changedValue");

    context.put(ActionContext.PARAMETERS, parametersCopy);

    return invocation.invoke();
}