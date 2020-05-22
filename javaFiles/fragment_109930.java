public class VersioningPropertiesIntrospector {
    private String version;

    public VersioningPropertiesIntrospector(String version) {
        this.version = version;
    }

    @Override
    pubilc PropertyName findNameForSerialization(Annotated a) {
        PropertyName propertyName = findNameFromVersioningProperties(a);
        if (propertyName != null) {
            return propertyName;
        }
        return super.findNameForSerialization(a);
    }

    @Override
    pubilc PropertyName findNameForDeserialization(Annotated a) {
        PropertyName propertyName = findNameFromVersioningProperties(a);
        if (propertyName != null) {
            return propertyName;
        }
        return super.findNameForDeserialization(a);
    }

    private PropertyName findNameFromVersioningProperties(Annotated a) {
        VersioningProperties annotation = a.getAnnotation(VersioningProperties.class);
        if (annotation == null) {
            return null;
        }
        for (Property property : annotation.value()) {
            if (version.equals(property.version()) {
                return new PropertyName(property.value());
            }
        }
        return null;
    }
}