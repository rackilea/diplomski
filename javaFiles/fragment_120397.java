public class ConnectionClass {


String classDriver = "net.sourceforge.jtds.jdbc.Driver";
String db = "passoDB";
String un = "sa";
String password = "dhen1234";


 String ip = "";


 public ConnectionClass(Context context){
        SharedPreferences prefs = context.getSharedPreferences("MyPrefs", context.MODE_PRIVATE);
        ip = prefs.getString("serverIP", "");

 }


@SuppressLint("NewApi")
public Connection CONN(Context context) {

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
            .permitAll().build();
    StrictMode.setThreadPolicy(policy);
    Connection conn = null;
    String ConnURL = null;
    try {
        Class.forName(classDriver);
        ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
                + "databaseName=" + db + ";user=" + un + ";password="
                + password + ";";
        conn = DriverManager.getConnection(ConnURL);
    } catch (SQLException se) {
        Log.e("ERRO", se.getMessage());
    } catch (ClassNotFoundException e) {
        Log.e("ERRO", e.getMessage());
    } catch (Exception e) {
        Log.e("ERRO", e.getMessage());
    }
    return conn;
}
}