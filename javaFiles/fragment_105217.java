public class YourControllerClasss implements Controller
    public void perform(ComponentContext context,
      HttpServletRequest request,
      HttpServletResponse response,
      ServletContext servletContext)
      throws ServletException, IOException {

      //some logic to determine what the 'body' should be

      if (service.isUp()){
        request.setAttribute("nameOfJSPToImport", "/jsps/import-me.jsp");
      }else{
        request.setAttribute("nameOfJSPToImport", "/jsps/import-me-instead.jsp");
      }

    }
}