public class RenderStatisticsFilter implements RequestFilter {

   @Override
   public boolean service(Request request, Response response,
            RequestHandler handler) throws IOException {
       this.beforeRender();         
       final boolean result = handler.service(request, response);
       this.afterRender();
       return result;
   }

   private void beforeRender() {
       ...
   }

   private void afterRender() {
       ...
   }    

}