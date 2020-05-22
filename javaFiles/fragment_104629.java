@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Mapped {
    String value() default "";
    String defaultValue() default "";
}