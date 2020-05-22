public static String getProperty(String propertyName) {
        String value = Singelton().props.getProperty(propertyName);
        if (value == null) {
            LOGGER.warning("propertyName (" + propertyName + ") not found in property file (" + FULL_PATH + ")");
        }

        return value;
    }