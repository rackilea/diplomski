@AroundInvoke
public Object intercept(InvocationContext ctx) throws Exception {
    Principal principal = sessionCtx.getCallerPrincipal();
    String previousPrincipalName = MDC.get("USER_KEY");

    MDC.put("USER_KEY", principal == null ? "" : principal.getName());

    try {
        return ctx.proceed();
    } finally {
        MDC.put("USER_KEY", previousPrincipalName);
    }
}