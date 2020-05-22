public class MySessionListner implements HttpSessionListener {
     public void sessionCreated(HttpSessionEvent se) {
          return; //or maybe do something, depends on what you need
     }

     public void sessionDestroyed(HttpSessionEvent se) {
          HttpSession session = se.getSession();
          //do whatever you need to do
     }
 }