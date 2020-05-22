public class LoginInterceptor extends HandlerInterceptorAdapter {

public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        //Only check on several pages not all
        //Check if user is requesting the two JSP pages
        if (requestUri.startsWith(...)) {
        //Yes, user is requesting the two JSP
            if(/*Check if ip address is on the list*/) {
                //Yes, it is.
                 if (/*check sth else maybe?*/) {
                      //test passes
                      return true;
                 } else {
                      //test fails.
                      response.sendRedirect(request.getContextPath() + "error_1";
                       return false;
                 }
            } else {
                //oops, not on the list, redirect to error url
                response.sendRedirect(request.getContextPath() + "error_2";
                return false;
            }

        } else {
        //no need to check, just grant access
        return true;
        }
    }
}