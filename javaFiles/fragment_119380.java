private static Properties extractPropertiesFile() throws FileNotFoundException, IOException{

    String propertiesFilePath = System.getProperty("catalina.home") +
            File.separator + "lib"+ File.separator + "myapp.properties";

    Properties properties = new Properties();
    properties.load(new FileInputStream(propertiesFilePath));

    return properties;
}