package some.java.package;

import org.eclipse.persistence.config.SessionCustomizer; 
import org.eclipse.persistence.sessions.Session; 
import org.eclipse.persistence.sessions.DatabaseLogin; 

public class MySessionCustomizer implements SessionCustomizer {

  private String schema = "some_schema";
  public MySessionCustomizer() {
      schema = ... // read from property, jndi, etc.
  }

  public void customize(Session session) { 
      session.getLogin().setTableQualifier(schema);
  } 
}