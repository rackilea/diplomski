String driver = // get driver field value from UI
String url = // get url field from UI
String user = // get user field
String pass = // get pass field
BasicDataSource ds = new BasicDataSource();
ds.setDriverClassName(driver);
ds.setUrl(url);
ds.setUsername(user);
ds.setPassword(pass);
new DbAccessClass(ds);