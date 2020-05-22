@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomJsonProperty {
    String propertyName();

    String format();

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        CustomJsonProperty[] value();
    }

}