import javax.naming.InitialContext;
import javax.naming.NamingException;

...

public Object readJndi(String paramName) {
  Object jndiValue = null;
  try {
    final InitialContext ic = new InitialContext();
    jndiValue = ic.lookup("java:comp/env/" + paramName);
  } catch (NamingException e) {
    // handle exception
  }
  return jndiValue;
}


public String getConfigPath() {
  return (String) readJndi("param.file");
}