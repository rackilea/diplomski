public class LoginPageRedirectInterceptor extends HandlerInterceptorAdapter {

    private String[] loginPagePrefixes = new String[] { "/login" };

    private String redirectUrl =  "/";

    private UrlPathHelper urlPathHelper = new UrlPathHelper();

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        if (isInLoginPaths(this.urlPathHelper.getLookupPathForRequest(request))
                && isAuthenticated()) {                
            response.setContentType("text/plain");
            sendRedirect(request, response);
            return false;
        } else {
            return true;
        }
    }


    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext()
                                             .getAuthentication();
        if (authentication == null) {
            return false;
        }
        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }
        return authentication.isAuthenticated();
    }

    private void sendRedirect(HttpServletRequest request,
                              HttpServletResponse response) {

        String encodedRedirectURL = response.encodeRedirectURL(
                           request.getContextPath() + this.redirectUrl);
        response.setStatus(HttpStatus.SC_TEMPORARY_REDIRECT);
        response.setHeader("Location", encodedRedirectURL);
    }

    private boolean isInLoginPaths(String requestUrl) {

        for (String login : this.loginPagePrefixes) {
            if (requestUrl.startsWith(login)) {
                return true;
            }
        }
        return false;
    }
}