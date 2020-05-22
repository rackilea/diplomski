public final class Singleton {

private static volatile Connection con = null;

private Singleton() {}

public static Singleton getInstance() {
    if (con== null) {
       try {
     con = DriverManager.getConnection(dbPath, user, pass);
     statm = con.createStatement();
    SetupSystem();
     } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
     }
     }

    return con;
 }