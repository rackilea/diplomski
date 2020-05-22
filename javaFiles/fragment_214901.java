@Interceptor
@CheckAction
public class CheckActionInterceptor implements Serializable {
    private static final long serialVersionUID = 1L;

    @AroundInvoke
    public Object checkPermissions(InvocationContext context) throws Exception {
        final CheckAction annotation = context.getMethod().getAnnotation(CheckAction.class);

        if (!isActionAllowed(annotation.object(), annotation.action())) {
            facesContext.addMessage("Error", new FacesMessage("Permission error", text));
            log.error(text);
            return null;
        }

        return context.proceed();
    }