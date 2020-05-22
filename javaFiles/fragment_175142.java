public class AuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // Very simple (most probably broken) check if the user is ADMIN or USER
        if (authentication.getAuthorities().stream().filter(a -> a.getAuthority().equals("USER")).findAny() != null){
            redirectStrategy.sendRedirect(request, response, "/profile.html");
        } else {
            redirectStrategy.sendRedirect(request, response, "/admin.html");
        }

        clearAuthenticationAttributes(request);
    }
}