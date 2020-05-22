@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OverrideInputType {
    // What the Content-Type request header value should be replaced by
    String value();

    // which Content-Type request header values should not be replaced
    String[] except() default {};
}