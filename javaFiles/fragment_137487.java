public PojoFilter implements javax.servlet.Filter {

    private static final ThreadLocal<Pojo> POJO = new ThreadLocal<Pojo>();

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
         try {
             Pojo pojo = createPojoFrom(request);
             POJO.set(pojo);
             filterChain.doFilter(request, response);
         } finally {
             POJO.remove();
         }
    }

    public static currentPojo() {
        return POJO.get();
    }

    ...
}