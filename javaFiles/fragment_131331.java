// Singleton:
public class G{
   private volatile double[][] data;
   private G instance;
   public static G getInstance(){
       // I don't synchronize because I rely on ServletContextListener to initialize once       
       if(data==null) 
           data=... // complex loading
       return data;
   }
}
// ServletContextListener:
public void contextInitialized(ServletContext ctx) {
   G.getInstance();
}
// Usage in servlet:
doGet(){
   G g=G.getInstance(); // I don't like it in terms of OOD, but it works
}