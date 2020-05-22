Yes it's possible in Spring controller,

Try this in Spring controller:

public void requestedURL(HttpServletRequest req, HttpServletResponse res){

String jspParameter = request.getParameter("param_name");
req.getRequestDispatcher("your servlet url pattern?param1="+jspParameter)
                                     .forward(req, res);

}