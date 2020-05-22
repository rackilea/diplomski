private Filter ssoFilter() {
        OAuth2ClientAuthenticationProcessingFilter authFilter = new OAuth2ClientAuthenticationProcessingFilter(
                "/login");

        authFilter.setSessionAuthenticationStrategy(new SessionAuthenticationStrategy() {
            @Override
            public void onAuthentication(Authentication authentication, HttpServletRequest request,
                    HttpServletResponse response) throws SessionAuthenticationException {
                LinkedHashMap<String, Object> userDets = (LinkedHashMap<String, Object>) ((OAuth2Authentication) authentication)
                        .getUserAuthentication().getDetails();
                response.addCookie(new Cookie("authenticated", userDets.get("email").toString()));
            }
        });

        OAuth2RestTemplate oAuthTemplate = new OAuth2RestTemplate(oAuth2ResourceDetails(), oauth2ClientContext);
        UserInfoTokenServices tokenServices = new UserInfoTokenServices(oAuth2Resource().getUserInfoUri(),
                oAuth2ResourceDetails().getClientId());

        authFilter.setRestTemplate(oAuthTemplate);
        tokenServices.setRestTemplate(oAuthTemplate);
        authFilter.setTokenServices(tokenServices);

        return authFilter;
    }