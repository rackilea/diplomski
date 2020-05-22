@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        final HttpSession session = request.getSession();
        final String code = Strings.nullToEmpty(request.getParameter("code"));

        if (!code.isEmpty()) {
            this.getAccessToken(response, session, code);
        } else {
            this.getOAuth2AuthorizationUrl(response, session);
        }
    }