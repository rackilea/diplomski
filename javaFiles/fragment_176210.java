@Component
public class TokenValidatorWSO2 implements OAuth2TokenValidator{

    private static final Logger logger = Logger.getLogger(TokenValidatorWSO2.class);

    @Value("${server_url}")
    private String serverUrl;

    @Value("${validation_service_name}")
    private String validationServiceName;

    @Value("${comsumer_key}")
    private String consumerKey;

    @Value("${admin_username}")
    private String adminUsername;

    @Value("${admin_password}")
    private String adminPassword;

    private OAuth2TokenValidationServiceStub stub;

    private static final int TIMEOUT_IN_MILLIS = 15 * 60 * 1000;

    public TokenValidationResponse validateAccessToken(String accessToken) throws ApplicationException {
        logger.debug("validateAccessToken(String) - start");

        if(stub == null) {
            initializeValidationService();
        }

        OAuth2TokenValidationRequestDTO  oauthRequest;
        TokenValidationResponse validationResponse;
        OAuth2TokenValidationRequestDTO_OAuth2AccessToken oAuth2AccessToken;

        try {
            oauthRequest = new OAuth2TokenValidationRequestDTO();
            oAuth2AccessToken = new OAuth2TokenValidationRequestDTO_OAuth2AccessToken();
            oAuth2AccessToken.setIdentifier(accessToken);
            oAuth2AccessToken.setTokenType("bearer");
            oauthRequest.setAccessToken(oAuth2AccessToken);
            OAuth2TokenValidationResponseDTO response = stub.validate(oauthRequest);

            if(!response.getValid()) {
                throw new ApplicationException("Invalid access token");
            }

            validationResponse = new TokenValidationResponse();
            validationResponse.setAuthorizedUserIdentifier(response.getAuthorizedUser());
            validationResponse.setJwtToken(response.getAuthorizationContextToken().getTokenString());
            validationResponse.setScope(new LinkedHashSet<String>(Arrays.asList(response.getScope())));
            validationResponse.setValid(response.getValid());

        } catch(Exception ex) {
            logger.error("validateAccessToken() - Error when validating WSO2 token, Exception: {}", ex);
        }

        logger.debug("validateAccessToken(String) - end");
        return validationResponse;
    }

    private void initializeValidationService() throws ApplicationException {
        try {
            String serviceURL = serverUrl + validationServiceName;
            stub = new OAuth2TokenValidationServiceStub(null, serviceURL);
            CarbonUtils.setBasicAccessSecurityHeaders(adminUsername, adminPassword, true, stub._getServiceClient());
            ServiceClient client = stub._getServiceClient();
            Options options = client.getOptions();
            options.setTimeOutInMilliSeconds(TIMEOUT_IN_MILLIS);
            options.setProperty(HTTPConstants.SO_TIMEOUT, TIMEOUT_IN_MILLIS);
            options.setProperty(HTTPConstants.CONNECTION_TIMEOUT, TIMEOUT_IN_MILLIS);
            options.setCallTransportCleanup(true);
            options.setManageSession(true);
        } catch(AxisFault ex) {
            // Handle exception
        }
    }
}