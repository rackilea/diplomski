public static Properties loadProperties() {
        String resourceName = "version.properties";

        Properties prop = new Properties();
        try {
            prop.load(DBTools.class.getResourceAsStream(resourceName));
            logger.trace(String.format("config file %s loadded with success !", resourceName));
        } catch (IOException e) {
            logger.error(String.format("config file %s is not loaded!", resourceName));
        }
        return prop;
    }



  version.properties File 
    APP-VERSION=1.12.4-REV2345-NIGHT