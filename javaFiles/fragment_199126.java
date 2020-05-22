// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

//Load Driver
try {
  // The newInstance() call is a work around for some
  // broken Java implementations
  Class.forName("com.mysql.jdbc.Driver").newInstance();
} catch (Exception ex) {
  // handle the error
}

con=DriverManager.getConnection(connectieString);
System.out.println ("Database connection established");