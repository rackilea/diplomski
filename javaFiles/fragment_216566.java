public class MvcPreAuthorizeAnnotationCheckerInterceptor extends HandlerInterceptorAdapter {
    final HandlerMethod hm;
    if (handler instanceof HandlerMethod) {
        hm = (HandlerMethod) handler;
        PreAuthorize annotation = hm.getMethodAnnotation(PreAuthorize.class);
        if (annotation == null) {
            // check if the class is annotated...
            annotation = hm.getMethod().getDeclaringClass().getAnnotation(PreAuthorize.class);
            if (annotation == null) {
                // add logging
                // or send a NON AUTHORIZED
                response.sendRedirect(request.getContextPath());
            }
       }
       return true;
    }
}