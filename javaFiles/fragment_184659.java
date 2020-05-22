@Override
public void apply(RequestTemplate template) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    if (auth != null){
        String tokenValue = null;
        if (auth.getDetails() instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) auth.getDetails();
            tokenValue = details.getTokenValue();
        } else if (auth.getDetails() instanceof InternalOAuth2Details) {
            InternalOAuth2Details details = (InternalOAuth2Details) auth.getDetails();
            tokenValue = details.getTokenValue();
        }
        if (tokenValue == null) {
            log.warn("Current token value is null");
            return;
        }
        template.header("Authorization", "Bearer " + tokenValue);
    }
}