import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

public class FilterToGetTimeOut extends OncePerRequestFilter {

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        try {
            if(request.getRequestURI().equals("/") || request.getRequestURI().equals("/Login/")){
                if(request.getSession().getAttribute("login") != null && (Boolean)request.getSession().getAttribute("login") == true){
                    response.sendRedirect(URL);     //After login page
                }
            } else if(request.getSession().getAttribute("login") == null && !request.getRequestURI().equals("/LogOut")){
                response.sendRedirect(request.getContextPath()+"/?timeout=true");   //If timeout is true send session timeout error message to JSP
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            //Log Exception

        }
    }
}