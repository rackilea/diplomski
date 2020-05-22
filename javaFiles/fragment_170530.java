public class SessionCounterListener implements HttpSessionListener {

  private static int totalActiveSessions;

  public static int getTotalActiveSession(){
    return totalActiveSessions;
  }

  @Override
  public void sessionCreated(HttpSessionEvent event) {
    totalActiveSessions++;
 }

  @Override
  public void sessionDestroyed(HttpSessionEvent event) {
    totalActiveSessions--;
  } 
}


<web-app ...>
    <listener>
    <listener-class>SessionCounterListener</listener-class>
</listener>
</web-app>