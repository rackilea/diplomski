public class FilteringPropertiesFactoryBean extends PropertiesFactoryBean {

    private String namePrefix;

    @Override
    protected Properties mergeProperties() throws IOException {
        Properties unfilteredProperties = super.mergeProperties();

        Properties filteredProperties = new Properties();

        // iterator over keys
        // discard entries whose key doesn't start with prefix
        for (Object key : unfilteredProperties.keySet()) {
            String name = key.toString();

            // trim the property name by removing the target prefix.
            String trimmedName = trimName(name);
            if (trimmedName != null) {
                // add the property to the filtered collection
                String value = unfilteredProperties.getProperty(name);
                filteredProperties.setProperty(trimmedName, value);
            }
        }

        return filteredProperties;
    }

    public void setNamePrefix(String value) {
        this.namePrefix = value;
    }

    private String trimName(String name) {
        // does name start with the prefix and is the name longer than the prefix
        if (name.startsWith(namePrefix) && name.length() > namePrefix.length()) {
            return name.substring(namePrefix.length());
        }
        return null;
    }

}