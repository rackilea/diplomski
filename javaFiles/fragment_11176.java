// returns null if path does not exist
InputStream is = YourClass.class.getResourceAsStream("/test.properties");
if (is != null) {
   Properties properties = new Properties();
   properties.load(is);
   //... 
}