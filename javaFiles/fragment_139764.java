public ConverterProperties getProperties() {
    if (properties == null) {
        properties = new ConverterProperties()
            .setBaseUri("resources/zugferd/");
    }
    return properties;
}