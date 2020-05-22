@WebFilter(filterName="exceptionHandler", urlPatterns="/*")
public class ExceptionHandler extends HttpFilter {

    @EJB
    private ExceptionPersister exceptionPersister;

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, HttpSession session, FilterChain chain) throws ServletException, IOException {

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            exceptionPersister.persist(e);
        }
    }
}