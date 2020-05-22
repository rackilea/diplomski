private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
   ...
   .formLogin()
   .loginPage("/login")
   .successHandler(new AuthenticationSuccessHandler() {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        redirectStrategy.sendRedirect(request, response, "/");
    }
})