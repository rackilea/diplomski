@Component
public class TosFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println(request.getRequestURI());

        // In realworld scenario HelloWorldController.acceptedTOS is a persisted value rather than a static variable
        if(!HelloWorldController.acceptedTOS){
            //response.sendRedirect("/no-tos");
            request.getRequestDispatcher("error-no-tos").forward(request, response);
        }
        filterChain.doFilter(request,response);
    }
}