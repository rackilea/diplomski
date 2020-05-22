public class MyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    @Override
    protected String resolvePlaceholder(String placeholder, Properties props) {
        String value = Configuration.getDb().get(placeholder)
        if (value == null) {
            value = super.resolvePlaceholder(placeholder, props);
        }
        return value;
    }
}