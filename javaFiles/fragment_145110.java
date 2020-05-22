public class TranslationServlet extends javax.servlet.http.HttpServlet {


      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          Locale locale = getLocaleBasingOnRequest(HttpServletRequest request); // read the locale sent by browser by accesing request.getLocales()

          ResourceBundle bundle = ResourceBundle.getBundle("Translations_file", locale); // get the tranlation strings

          resp.getWriter().println("var translations = new Object();");
          for (String key : bundle.keySet()) {
              resp.getWriter().println("translations[\"" + key + "\"] = \"" +   bundle.getString(key) + "\";");
          }

      }
}