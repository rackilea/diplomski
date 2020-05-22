public class SamlAutomaticLogout extends SimpleUrlLogoutSuccessHandler {
/**
 * Name of parameter of HttpRequest indicating whether this call should perform only local logout.
 * In case the value is true no global logout will be invoked.
 */
private static final String LOGOUT_PARAMETER = "local";

@Autowired
private SingleLogoutProfile profile;

@Autowired
private SAMLContextProvider contextProvider;

@Override
public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                            Authentication authentication) throws IOException, ServletException {
    try {
        if (authentication != null && isGlobalLogout(request, authentication)) {

            Assert.isInstanceOf(SAMLCredential.class, authentication.getCredentials(),
                "Authentication object doesn't contain SAML credential, cannot perform global logout");

            // Terminate the session first
            HttpSession session = request.getSession(false);
            SecurityContextHolder.clearContext();
            if (session != null) {
                session.invalidate();
            }

            // Notify session participants using SAML Single Logout profile
            SAMLCredential credential = (SAMLCredential) authentication.getCredentials();
            request.setAttribute(SAMLConstants.LOCAL_ENTITY_ID, credential.getLocalEntityID());
            request.setAttribute(SAMLConstants.PEER_ENTITY_ID, credential.getRemoteEntityID());
            SAMLMessageContext context = contextProvider.getLocalAndPeerEntity(request, response);
            profile.sendLogoutRequest(context, credential);
        }
    } catch (SAMLException e) {
        logger.debug("Error initializing global logout", e);
        throw new ServletException("Error initializing global logout", e);
    } catch (MetadataProviderException e) {
        logger.debug("Error processing metadata", e);
        throw new ServletException("Error processing metadata", e);
    } catch (MessageEncodingException e) {
        logger.debug("Error encoding outgoing message", e);
        throw new ServletException("Error encoding outgoing message", e);
    }

    super.onLogoutSuccess(request, response, authentication);
}

private boolean isGlobalLogout(HttpServletRequest request, Authentication auth) {
    String localLogout = request.getParameter(LOGOUT_PARAMETER);
    return (localLogout == null || !"true".equals(localLogout.toLowerCase().trim()))
        && (auth.getCredentials() instanceof SAMLCredential);
}