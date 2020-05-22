@WebFilter("/path/to/your/pdf/*")
public class FileFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        if (session == null) {
            User user = (User)session.getAttribute("user");
            if (validateUserForPdfDownload(user)) {
                //user can download the file
                chain.doFilter(req, res);
            } else {
                //user must not download the file
                //redirect user to some URL
                response.sendRedirect(request.getContextPath() + "/index.html");
            }
        }
    }

    public boolean validateUserForPdfDownload(User user) {
        //define the logic to validate if user is able to download the file
    }
}