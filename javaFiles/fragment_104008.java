public class CustomizedAntRequestMatcher implements RequestMatcher {
    @Override
    public boolean matches(HttpServletRequest request) {
        String url = "/saml/SSO/**"; //change this line to get your dynamic configuration
        AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher(url);
        return antPathRequestMatcher.matches(request);
    }
}