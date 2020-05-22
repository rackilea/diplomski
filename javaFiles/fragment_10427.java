public static ThreadLocal servletRequestHolder  = new ThreadLocal();
public static HttpServletRequest getCurrentRequest(){
    return (HttpServletRequest) servletRequestHolder.get();
}
@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
   servletRequestHolder.set( request );
...........
}