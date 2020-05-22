@Override
public String intercept(ActionInvocation ai) throws Exception {
    final ActionContext context = ai.getInvocationContext();

    // Struts Session
    Map<String, Object> session = context.getSession();