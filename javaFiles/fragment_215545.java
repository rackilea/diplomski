// Oracle 8 connection
File jar = new File("/path/to/oracle8.jar");
URL[] cp = new URL[1];
cp[0] = jar.toURI().toURL();
URLClassLoader ora8loader = new URLClassLoader(cp, ClassLoader.getSystemClassLoader());
Class drvClass = ora8loader.loadClass("oracle.jdbc.driver.OracleDriver");
Driver ora8driver = (Driver)drvClass.newInstance();

Properties props = new Properties();
// "user" instead of "username"
props.setProperty("user", "my-user");
props.setProperty("password", "my-password");
Connection ora8conn = ora8driver.connect("jdbc:oracle:thin:@some-oracle-8-server:port:sid",props);