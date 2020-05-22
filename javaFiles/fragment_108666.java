@WebFilter(filterName="exceptionHandler", urlPatterns="/*")
public class ExceptionHandler extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, HttpSession session, FilterChain chain) throws ServletException, IOException {

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            // ... handle exception here
        }
    }
}