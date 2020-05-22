public HttpServletRequest getOriginalServletRequest(
    HttpServletRequest request) {

    HttpServletRequest originalRequest = request;

    while (originalRequest.getClass().getName().startsWith(
                "com.liferay.")) {

        // Get original request so that portlets inside portlets render
        // properly

        originalRequest = (HttpServletRequest)
            ((HttpServletRequestWrapper)originalRequest).getRequest();
    }

    return originalRequest;
}