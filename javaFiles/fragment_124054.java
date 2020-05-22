public void doFilter(ServletRequest request, ServletResponse response,
   FilterChain chain) 
   throws java.io.IOException, javax.servlet.ServletException
{   
    OutputStream out = response.getOutputStream()

    response.setCharacterEncoding('UTF-8')
    response.setContentType('text/plain')

    def saw = 'АБВГДЕЙКА ЭТО НЕПРОСТАЯ ПЕРЕДАЧА ABCDEFGHIJKLMNOP!!!'

    response.setContentLength(saw.length())
    out.write(content.getBytes("UTF-8"));

}