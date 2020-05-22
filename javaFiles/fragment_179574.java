import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
      ServletException {
    HttpServletRequest request = (HttpServletRequest) req;         
    HttpSession session = request.getSession(false);
    HttpServletResponse response = (HttpServletResponse) resp;
    if (session == null) {
      // no session has been established yet      
    }
    chain.doFilter(req, resp); 
  }

  public void destroy() {
    // TODO Auto-generated method stub

  }

  public void init(FilterConfig filterConfig) throws ServletException {
    // TODO Auto-generated method stub

  }
}