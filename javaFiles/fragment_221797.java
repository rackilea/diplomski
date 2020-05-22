@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private @Autowired ErrorMessage errorMessage;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex) throws IOException, ServletException {
        //String json = String.format("{\"errorcode\": \"%s\", \"message\": \"%s\"}", response.getStatus(), ex.getMessage());
        String json = String.format("{\"errorcode\": \"%s\", \"message\": \"%s\"}", errorMessage.getStatus(), errorMessage.getMessage());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}