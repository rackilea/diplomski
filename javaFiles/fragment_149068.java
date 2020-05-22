@Override
public void doFilter(ServletRequest request, ServletResponse response,  FilterChain chain) throws IOException, ServletException {

    System.out.println("before");
    chain.doFilter(request, response);  
    System.out.println("after");
}