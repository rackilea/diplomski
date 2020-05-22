import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.support.MultipartFilter;

public class MyMultipartFilter extends MultipartFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
       HttpServletResponse response, FilterChain filterChain)
       throws ServletException, IOException {

       request.setCharacterEncoding("UTF-8");
       request.getParameterNames();

       super.doFilterInternal(request, response, filterChain);
    }
}