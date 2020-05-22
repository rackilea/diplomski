public void _jspService(HttpServletRequest request, HttpServletResponse response)
    throws java.io.IOException, ServletException {
     JspWriter out = null;
     ...
     out.write(someVariable); // local variable that is never declared
     ...
}