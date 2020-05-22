FilterChainInvoker filterChain = getFilterChain(request);
    if (filterChain != null) {
        filterChain.invokeFilterChain(servletRequest, servletResponse);
    } else {
        servletInstance.service(servletRequest, servletResponse);
    }
} catch (Throwable ex) {
    LOGGER.log(Level.SEVERE, "service exception:", ex);
    customizeErrorPage(response, "Internal Error", 500);
}