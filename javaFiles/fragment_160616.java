public void checkAutoLogin() throws IOException {
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    Cookie autoLogin = externalContext.getRequestCookieMap().get("autoLoginCookieName");

    if (autoLogin != null) {
        User user = decryptCookieValueAndExtractUser(autoLogin.getValue()); // Yes, it must be encrypted! Otherwise a too easy hack.

        if (user != null) {
            HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

            try {
                request.login(user.getName(), user.getPassword());
                String originalRequestURI = externalContext.getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);
                externalContext.redirect(originalRequestURI != null ? originalRequestURI : "someDefaultIndex.xhtml");
            } catch (ServletException e) {
                // Login failed. It's up to you how to handle it.
            }
        }
    }
}