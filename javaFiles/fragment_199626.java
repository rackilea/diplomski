public class MyConnectionFactory

// To be replaced with a property lookup etc.
private boolean development = true;

public Connection getConnection(String jndiName)
  if (development)
    // get connection from BoneCP etc. (ignore jndiName)
  else {
    // lookup data source using JNDI, then get connection