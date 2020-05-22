public static void main(String[] args)
{
    // set up new properties object
        // from file "myProperties.txt"
        String propertyFiletoLoad = (String)(System.getProperty("PROPERTIES_FILE"));
        FileInputStream propFile =
            new FileInputStream( propertyFileToLoad);
        Properties p =
            new Properties();
        p.load(propFile);

        // set the system properties
        System.setProperties(p);

}