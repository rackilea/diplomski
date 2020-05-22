public class GenerationTimeFilter implements Filter {
    ...

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
       long startTime = System.currentTimeMillis();

       chain.doFilter(req, res);

       long elapsedTime = System.currentTimeMillis() - startTime;
    }
}