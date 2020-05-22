import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AjaxAuthenticationProcessingFilter extends
UsernamePasswordAuthenticationFilter {

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
            HttpServletResponse response,FilterChain filter, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response,filter, authResult);

    }

}