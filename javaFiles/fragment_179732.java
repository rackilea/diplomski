Properties prop = new Properties();
prop.put ("user", USER);
prop.put ("password", PASS);
// prop.put(propname, propValue);

Class.forName("oracle.jdbc.driver.OracleDriver");

enableLogging(false);

conn = DriverManager.getConnection("jdbc:oracle:thin:@"+HOST+":"+PORT+":"+SID, prop);