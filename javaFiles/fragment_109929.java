@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface VersioningProperties {    
    Property[] value();

    @interface Property {
        String version();
        String value();
    }
}