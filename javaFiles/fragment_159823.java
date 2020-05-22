public void doFilter(ServletRequest request, ServletResponse response, 
        FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest httpReq = (HttpServletRequest)request;
    String ua = httpReq.getHeader("User-Agent");

    Pattern patternEngineIE = Pattern.compile(".*Trident/(\\d).*");
    Matcher mEngineIE = patternEngineIE.matcher(ua);

    if (mEngineIE.find()) {
        int versionEngineIE = Integer.parseInt(mEngineIE.group(1));
        switch (versionEngineIE) {
        case 4:
            ua = ua.replaceAll("MSIE 7.0", "MSIE 8.0");
            response.addHeader("X-UA-Compatible", "IE=8");
            break;
        case 5:
            ua = ua.replaceAll("MSIE 7.0", "MSIE 9.0");
            response.addHeader("X-UA-Compatible", "IE=9");
            break;
        case 6:
            ua = ua.replaceAll("MSIE 7.0", "MSIE 10.0");
            response.addHeader("X-UA-Compatible", "IE=10");
            break;
        }
    }

    httpReq.addHeader("User-Agent", ua);
    filterChain.doFilter(httpReq, response);
}