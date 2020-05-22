public int doStartTag() throws JspException {
    ServletRequest request = pageContext.getRequest();
    ServletResponse response = pageContext.getResponse();

    RequestDispatcher disp = request.getRequestDispatcher("/test.jsp");
    try {
        disp.include(request, response);
    } catch (ServletException e) {
        throw new JspException(e);
    } catch (IOException e) {
        throw new JspException(e);
    }
    return super.doStartTag();
}