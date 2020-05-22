public class LoggedUserWebArgumentResolver implements WebArgumentResolver {

    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) {
        Annotation[] annotations = methodParameter.getParameterAnnotations();

        if (methodParameter.getParameterType().equals(User.class)) {
            for (Annotation annotation : annotations) {
                if (LoggedUser.class.isInstance(annotation)) {
                    Principal principal = webRequest.getUserPrincipal();
                    return (User)((Authentication) principal).getPrincipal();
                }
            }
        }
        return WebArgumentResolver.UNRESOLVED;
    }
}