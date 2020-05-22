@WebServlet(urlPatterns={"/asyncservlet"}, asyncSupported=true)
// Rather than @WebServlet, you can also specify these parameters in web.xml    
public class AsyncServlet extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) {
      response.setContentType("text/html;charset=UTF-8");
      final AsyncContext acontext = request.startAsync();
      acontext.start(new Runnable() {
         public void run() {
            // perform time consuming steps here.
            acontext.complete();
   }
}