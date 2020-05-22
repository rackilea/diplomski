public class MyFilter extends GenericFilterBean {

    @Autowired
    InjectedBean someInjectedBean;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }
}