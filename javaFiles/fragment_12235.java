class User {

    ...

    Map<String, Property> propertyMap = new HashMap<>();

    public Property getProperty(String propertyName) {
        return propertyMap .get(propertyName);
    }

    ...
}