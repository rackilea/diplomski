public class PropertiesAlgorithmImpl implements PropertiesAlgorithm {
private static final Logger logger = LoggerFactory.getLogger(PropertiesAlgorithmImpl.class);
private static Properties defaultProps = new Properties();

static {
    String propertiesDirectory = "config.properties";
    try (InputStream input = PropertiesAlgorithmImpl.class.getClassLoader().getResourceAsStream(propertiesDirectory)) {
        if (input == null) {
            logger.info("Sorry, unable to find " +  propertiesDirectory);
        }
        defaultProps.load(input);
        input.close();
    } catch (Exception e) { logger.info(String.valueOf(e.getStackTrace())); }
}

public String getValuesFromProperties(String key) {
    if (defaultProps.getProperty(key) != null) {
        return defaultProps.getProperty(key);
    }
        logger.info("Sorry, unable to find " + key);
        return "Sorry, unable to find " + key ;
}