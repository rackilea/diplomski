import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainClass {

public static void main(String[] args) {
    File jarFile = new File("Jar file location");
    for (File file : jarFile.listFiles()) {
        loadLibrary(file);
    }

    loadLibrary(jarFile);
    connectToDataBase();
}

private static void connectToDataBase() {
    try {
        Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
        Connection con = DriverManager.getConnection("jdbc:hive://172.22.75.***:10000/DBNamE", "****",
                "***");
        Statement preparedStatement = con.createStatement();
        preparedStatement.executeQuery("use rapid");
        ResultSet resultSet = preparedStatement.executeQuery("select count (*) from flight");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

public static synchronized void loadLibrary(java.io.File jar) {
    try {
        java.net.URLClassLoader loader = (java.net.URLClassLoader) ClassLoader.getSystemClassLoader();
        java.net.URL url = jar.toURI().toURL();
        for (java.net.URL it : java.util.Arrays.asList(loader.getURLs())) {
            if (it.equals(url)) {
                return;
            }
        }
        java.lang.reflect.Method method = java.net.URLClassLoader.class.getDeclaredMethod("addURL",
                new Class[] { java.net.URL.class });
        method.setAccessible(
                true); /* promote the method to public access */
        method.invoke(loader, new Object[] { url });
    } catch (final java.lang.NoSuchMethodException | java.lang.IllegalAccessException
            | java.net.MalformedURLException | java.lang.reflect.InvocationTargetException e) {
        e.printStackTrace();
    }

}
}