public class PropertiesUtil extends PropertyPlaceholderConfigurer {
private Properties properties;

@Override
protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) {
    super.processProperties(beanFactory, props);
    this.properties = props;
}

/**
 * Get property from properties file.
 * @param name property name
 * @return property value
 */
public String getProperty(final String name) {
    return properties.getProperty(name);
}
}