@Resource
private WebServiceContext context;

private void invokeServlet() throws IOException, ServletException
{
    ServletContext servletContext = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
    HttpServletRequest request = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
    HttpServletResponse response = (HttpServletResponse) context.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
    servletContext.getRequestDispatcher("/path/to/servlet").include(request, response);
}