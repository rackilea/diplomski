public class SimpleLoginInvalidator implements LogoutSuccessHandler {

private static final Logger logger = LoggerFactory.getLogger(SimpleLoginInvalidator.class);

@Override
public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    HttpSession session = request.getSession();
    try {
        String dimensionName = authentication.getPrincipal().getClass().getAnnotation(SecurityDimension.class).name();
        session.removeAttribute(dimensionName + "_" + SPRING_SECURITY_CONTEXT_KEY);
        logger.debug("Cleared security context for dimension: " + dimensionName);
    } catch (NullPointerException npe) {
        logger.debug("Could not clear custom security context attribute", npe);
    }
}