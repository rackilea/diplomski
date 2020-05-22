protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.debug("------------------------");
        log.debug("context: " + context);
        Identifier identifier = this.verifyResponse(req);
        log.debug("identifier: " + identifier);
        // if openid login succeded redirect to home page using our demo account
        if (identifier != null) {
            WebAuthentication pwl = new WebAuthentication();
            pwl.login("guest", "guest");**
            resp.sendRedirect("/index.jsp");
        } else {
            System.out.println("login with openid failed");
        }
    }