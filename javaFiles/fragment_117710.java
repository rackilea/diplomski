try {
    Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
} catch (ClassNotFoundException e) {
    throw new RuntimeException(e);
}
Properties info = new Properties();
info.setProperty("proxool.maximum-connection-count", "20");
info.setProperty("proxool.house-keeping-test-sql", " select CURDATE()");
info.setProperty("user", user);
info.setProperty("password", pass);
info.setProperty("proxool.alias", "mypoolname");
info.setProperty("proxool.url", "jdbc:mysql://localhost:3306/site_a");
info.setProperty("proxool.driver", "com.mysql.jdbc.Driver");
String url = "proxool.mypoolname";
ProxoolDatabasePool pool = new ProxoolDatabasePool(url, info);
....
Connection conn = pool.getConnection();
conn.setCatalog("site_b");
...