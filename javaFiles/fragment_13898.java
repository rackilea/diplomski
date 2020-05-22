public class RequestInformationFilter implements Filter {

   @Override
   public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        try {
            MDC.put("variableName", "variableValue");

            chain.doFilter(request, response);

        } finally {
            MDC.remove("variableName");
        }

    }

}