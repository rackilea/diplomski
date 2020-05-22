public class AccessDeniedExceptionHandler implements AccessDeniedHandler
{
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException ex) throws IOException, ServletException {
        response.setStatus(HttpStatus.FORBIDDEN);
    }
}