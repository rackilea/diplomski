public class CustomOAuth2RestTemplate extends OAuth2RestTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomOAuth2RestTemplate.class);
    private Long LAST_RESET = getCurrentTimeSeconds();
    private Long FORCE_EXPIRATION;

    public CustomOAuth2RestTemplate(OAuth2ProtectedResourceDetails resource) {
        super(resource);
        this.FORCE_EXPIRATION = 10800L; // 3h
    }

    public CustomOAuth2RestTemplate(OAuth2ProtectedResourceDetails resource,
            DefaultOAuth2ClientContext defaultOAuth2ClientContext, Long forceExpiration) {
        super(resource, defaultOAuth2ClientContext);
        this.FORCE_EXPIRATION = Objects.requireNonNull(forceExpiration, "Please set expiration!");
    }

    @Override
    public synchronized OAuth2AccessToken getAccessToken() throws UserRedirectRequiredException {
        final Long diff = getCurrentTimeSeconds() - LAST_RESET;

        /*
         * Either use a hardcoded variable or use the value stored in
         * context.getAccessToken().getAdditionalInformation().
         */
        if (diff > FORCE_EXPIRATION) {
            LOGGER.info("Access token has expired! Generating new one...");
            this.LAST_RESET = getCurrentTimeSeconds();
            final OAuth2ClientContext oAuth2ClientContext = getOAuth2ClientContext();
            oAuth2ClientContext.setAccessToken(null);
            return acquireAccessToken(oAuth2ClientContext);
        }
        return super.getAccessToken();
    }

    private Long getCurrentTimeSeconds() {
        return System.currentTimeMillis() / 1000L;
    }

}