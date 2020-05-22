@Override
public String intercept(ActionInvocation ai) throws Exception {
    final ActionContext context = ai.getInvocationContext();

    HttpServletRequest request = (HttpServletRequest)context.get(StrutsStatics.HTTP_REQUEST);

    // Http Session
    HttpSession session = request.getSession();