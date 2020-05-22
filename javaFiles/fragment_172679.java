@Bean
public AuthenticationFailureHandler customAuthenticationFailureHandler() {
    ExceptionMappingAuthenticationFailureHandler exceptionMappingAuthenticationFailureHandler =
            new ExceptionMappingAuthenticationFailureHandler();
    Map<Object, Object> map = new HashMap<>();
    map.put(
            "org.springframework.security.authentication.CredentialsExpiredException",
            "/resetPassword.html"
    );        

    exceptionMappingAuthenticationFailureHandler.setExceptionMappings(map);

    exceptionMappingAuthenticationFailureHandler.setRedirectStrategy(
            new RedirectStrategy() {
                @Override
                public void sendRedirect(
                        HttpServletRequest request, HttpServletResponse response, String url
                ) throws IOException {
                    response.sendRedirect(request.getContextPath() + url);
                }
            }
    );

    return exceptionMappingAuthenticationFailureHandler;
}