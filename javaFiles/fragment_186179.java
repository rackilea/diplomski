$ javac -source 1.6 -target 1.6 -bootclasspath <path to Java 1.6 JRE>/lib/rt.jar MyDataSource.java 
$ file MyDataSource.class 
MyDataSource.class: compiled Java class data, version 50.0 (Java 1.6)
$ javap MyDataSource
Compiled from "MyDataSource.java"
public class MyDataSource implements javax.sql.DataSource {
  public MyDataSource();
  public java.io.PrintWriter getLogWriter() throws java.sql.SQLException;
  public void setLogWriter(java.io.PrintWriter) throws java.sql.SQLException;
  public void setLoginTimeout(int) throws java.sql.SQLException;
  public int getLoginTimeout() throws java.sql.SQLException;
  public <T extends java/lang/Object> T unwrap(java.lang.Class<T>) throws java.sql.SQLException;
  public boolean isWrapperFor(java.lang.Class<?>) throws java.sql.SQLException;
  public java.sql.Connection getConnection() throws java.sql.SQLException;
  public java.sql.Connection getConnection(java.lang.String, java.lang.String) throws java.sql.SQLException;
}