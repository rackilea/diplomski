public class MyLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication throws IOException, ServletException {
        // maybe do some other things ...
        super.handle(request, response, authentication);
    }
}