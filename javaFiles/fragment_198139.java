@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SomeAnnotation {
    public String name();
    public String value();
}