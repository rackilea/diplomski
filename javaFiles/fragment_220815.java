PrintWriter w = rsp.getWriter();
...
rsp.setStatus(HttpServletResponse.SC_OK);
rsp.setContentType("text/html");
rsp.addHeader("X-MyHeader", "Test");
RequestDispatcher rd = req.getRequestDispatcher("MyPage.jsp");
if ( rd != null )
    rd.include( req, rsp );