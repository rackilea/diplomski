Properties prop = new Properties();

try {
    prop.load(new FileInputStream("config.properties"));

    String connUrl = prop.getProperty("com.abc.project.model.jdbc.ConnectionUrl");
    String theOtherConnUrl = System.getProperty("com.abc.project.model.jdbc.ConnectionUrl");

    if(theOtherConnUrl!=null){
        connUrl = theOtherConnUrl;
           ...