import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ActiveUserCounter implements HttpSessionListener {  

      private static AtomicInteger activeSessions = new AtomicInteger();    

      public void sessionCreated(HttpSessionEvent se) {  
              activeSessions.incrementAndGet();  
      }  

      public void sessionDestroyed(HttpSessionEvent se) {  
                if(activeSessions.get() > 0)  
                       activeSessions.decrementAndGet();  
      }  

     public static int getActiveSessions() {  
             return activeSessions.get();  
      }   
}