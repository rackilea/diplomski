ServletContext context = servletRequest.getSession().getServletContext();
// Or if you have the servlet instead of request, use this:
// ServletContext = servlet.getServletContext(); // see comment by BalusC
String virtualPath = "/images/myimage.jpg";
String realPath = context.getRealPath(virtualPath);

// realPath will be D:\documents\images\myimage.jpg