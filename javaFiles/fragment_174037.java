try (InputStream input = new FileInputStream("config.properties")) {

Properties prop = new Properties();

// load a properties file
prop.load(input);

// get the property value and print it out
String prop1 = prop.getProperty("prop1");
String prop2 = prop.getProperty("prop2");

System.out.println("prop1 = " + prop1);
System.out.println("prop2 = " + prop2);

} catch (IOException ex) {
  ex.printStackTrace();
  // TODO: improve error handling
}