@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException 
{
    //your business logic
    // construct responseToSend
    response.getOutputStream().write(responseToSend);
    return;
}