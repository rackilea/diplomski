private static final String PROPERTIES_FILE = "com/package/Resource.properties";

     Properties properties = new Properties();  
     properties.load(this.getClass().getResourceAsStream(PROPERTIES_FILE));  
     String name = props.getProperty("name");  
     String email = props.getProperty("email");  
     String description = props.getProperty("description");