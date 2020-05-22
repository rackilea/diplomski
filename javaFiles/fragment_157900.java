public class ConnectToDataBase {

    public static void connectToDataBase() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/employees";
        try {
            LoadJarUtil.loadAllJars();
            Properties properties = new Properties();
            properties.put("user", "****");
            properties.put("password", "****");
            @SuppressWarnings("unchecked")
            Class<Driver> driver = (Class<Driver>) Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver", false,
                    ClassLoader.getSystemClassLoader());
            Connection connection = driver.newInstance().connect("jdbc:hive://172.22.***:10000", properties);
            System.out.println("Connected");
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

}