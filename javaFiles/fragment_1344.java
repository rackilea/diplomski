public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("_method");
        if ("form".equals(method)) {
            this.doForm(request, response);
        } else {
            if ("delete".equals(method)) {
                this.doDelete(request, response);
            } else {
        super.service(request, response);
            }
        }
   }

   protected void doForm(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException();
   }

}