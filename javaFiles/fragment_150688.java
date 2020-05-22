public class ReadTwiceFilter implements Filter {

@Override
public void destroy() {
}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

    ReadTwiceHttpServletRequestWrapper readTwiceHttpServletRequestWrapper = new ReadTwiceHttpServletRequestWrapper(
            (HttpServletRequest) request);

    String newBody = readTwiceHttpServletRequestWrapper.getBody().replace("<soap:studentId>1</soap:studentId>", "<soap:studentId>2</soap:studentId>");
    readTwiceHttpServletRequestWrapper.setBody(newBody);

    chain.doFilter(readTwiceHttpServletRequestWrapper, response);
}

@Override
public void init(FilterConfig arg0) throws ServletException {
}