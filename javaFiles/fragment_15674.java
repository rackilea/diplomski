public class FrameFilter extends GenericFilterBean { 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletResponse newResponse = response;

        if (request instanceof HttpServletRequest) {
            newResponse = new CharResponseWrapper((HttpServletResponse) response);
        }

        chain.doFilter(request, newResponse);

        if (newResponse instanceof CharResponseWrapper) {
           String modulContent = newResponse.toString();
           if (modulContent != null) {
                RestTemplate restTemplate = new RestTemplate();
                String frame = restTemplate.getForObject("FRAMEURL", String.class);
                String completeView = this.mergeFrameAndContent(frame, modulContent);
                response.getWriter().write(completeView);
            }
        }
    }
}