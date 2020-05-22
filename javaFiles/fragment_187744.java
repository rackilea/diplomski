public class UserFilter implements Filter {

public UserFilter() {
}

public void destroy() {
}

 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      String requri = ((HttpServletRequest) request).getRequestURI().substring(((HttpServletRequest) request).getContextPath().length() + 1);
        HttpSession session = (((HttpServletRequest) request).getSession());

        String RequestedUsername = null;

        if(requri.contains("user/")){
          //get the username after "user/"
          RequestedUsername=requri.substring(5);
          if(!RequestedUsername.isEmpty()){
           //if not empty set session
           session.setAttribute("loggedInUser",RequestedUsername);
             }
        }

      //forward to servlet which will set user details etc... (just get the user session variable from there) in that servlet you forward to landinglogin.jsp
      request.getRequestDispatcher("/profile").forward(request, response);


     }