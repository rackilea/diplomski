public class MultipleLoginFilter extends OncePerRequestFilter {

private static final Pattern pattern = Pattern.compile("(?<!/)/([^/?#]+)");

@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    logger.debug("Performing multiple login management");
    HttpSession session = request.getSession(false);

    String path = request.getRequestURI().replace(request.getContextPath(), "");
    String desiredDimension = getDesiredDimension(path);
    logger.debug("Requesting security context for security dimension: " + desiredDimension);

    SecurityContext context = (SecurityContext) session.getAttribute(SPRING_SECURITY_CONTEXT_KEY);
    if (context == null) {
        logger.debug("Current context is empty, trying to find and associate the one stored session...");
        populateSecurityContextByDimension(session, desiredDimension);
    } else {
        logger.debug("Extracted non-null current security context: " + context);
        String dimensionName = context.getAuthentication().getPrincipal().getClass().getAnnotation(SecurityDimension.class).name();
        if (!path.matches("/" + dimensionName + "(/.+)?")) {
            logger.debug("Extracted security context is not associated with desired security dimension(" + desiredDimension + "). Storing in session...");
            session.setAttribute(dimensionName + "_" + SPRING_SECURITY_CONTEXT_KEY, context);
            populateSecurityContextByDimension(session, desiredDimension);
        } else {
            logger.debug("Current security context is associated with desired security dimension, proceed as default.");
        }
    }
    filterChain.doFilter(request, response);
}

private String getDesiredDimension(String requestUrl) {

    Matcher m = pattern.matcher(requestUrl);
    String desiredDimension = "";
    if (m.find() && m.groupCount() == 1) {
        desiredDimension = m.group(1);
    } else {
        logger.error("Could not identify desired security dimension from url: " + requestUrl);
    }
    return desiredDimension;
}

private void populateSecurityContextByDimension(HttpSession session, String desiredDimension) {
    logger.debug("Extracting stored security context associated with desired dimension(" + desiredDimension + ")...");
    SecurityContext localContext = (SecurityContext) session.getAttribute(desiredDimension + "_" + SPRING_SECURITY_CONTEXT_KEY);
    session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, localContext);
    if(localContext != null) {
        logger.debug("Storing extracted context as current, context: " + localContext);
    } else {
        logger.debug("No security context for dimension(" + desiredDimension + ") in session, assigning null.");
    }
}