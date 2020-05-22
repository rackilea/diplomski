public abstract static class ConfigTypeAnnotation
        extends AnnotationLiteral<ConfigType>
        implements ConfigType { }

public static ConfigType getConfigTypeAnnotation(final Class<?> type) {
    return new ConfigTypeAnnotation() {
        @Override
        public Class<?> value() {
            return type;
        }
    };
}