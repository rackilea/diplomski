public void doFilter(ServletRequest request,
   ServletResponse response, FilterChain chain) {

    long start = System.nanoTime();
    chain.doFilter(request, response);
    long end = System.nanoTime();
    // log end-start
}