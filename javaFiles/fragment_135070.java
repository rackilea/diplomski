WorklightConfiguration config = WorklightConfiguration.getInstance ();
Properties properties = config.getAllProperties ();

for (String propertyName: properties.propertyNames ()) {
    String property = properties.getProperty (propertyName);
    // rest of implementation...
}