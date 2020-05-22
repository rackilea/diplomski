public class CustomFilter extends GenericFilterBean {

@Override
public void doFilter(
  ServletRequest request, 
  ServletResponse response,
  FilterChain chain) throws IOException, ServletException {
    chain.doFilter(request, response);
       }
   }