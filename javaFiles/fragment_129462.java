public class CharConversionExpFilter implements Filter {

    private char[] forbiddenChars;  // ADDED
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        forbiddenChars = filterConfig.getInitParameter("forbiddenChars")
                               .replace(",", "").toCharArray(); // ADDED
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        try {
            validateParameters((HttpServletRequest) request);  // ADDED
            chain.doFilter(request, response);
        } catch (IOException e) {
            if (e instanceof CharConversionException) {
                if ("true".equalsIgnoreCase(filterConfig.getInitParameter("useErrorPage"))) {
                    if (response instanceof HttpServletResponse) {
                        ((HttpServletResponse) response).sendError(400,
                        "The request cannot be fulfilled due to bad input.\nError:" + e.getMessage());
                    }
                } else {
                    request.setAttribute("errorMessage", e.getMessage());
                    filterConfig.getServletContext().getRequestDispatcher(requestURI).forward(request, response);
                }
            }
        }
    }

    // ADDED
    private void validateParameters(HttpServletRequest request) throws CharConversionException {
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameter = request.getParameter(parameterNames.nextElement());
            if (parameter != null && parameter.length() > 0) {
                for (char forbidChar : forbiddenChars) {
                    if (parameter.indexOf(forbidChar) != -1) {
                        throw new CharConversionException(
                                String.format(
                                        "Parameter: [%s] contains the forbidden character [%c]",
                                        parameter, forbidChar));
                    }
                }
            }
        }
    }

    @Override
    public void destroy() {}
}