// Class to encapsulate date:
public class G{
   private double[][] data;
   public static G loadData(){
      data=...// complex loading
   }
}
// Usage in ServletContextListener:
public class MyListener implements ServletContextListener{
   public void contextInitialized(ServletContext ctx) {
         G g= G.loadData();
         ctx.put("myData", g);
   }
// Usage is Servlet:
doGet(...){
    G g=(G) getServletContext().getAttribute("myData");
}