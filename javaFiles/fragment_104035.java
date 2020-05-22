@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface Contains {
    Class<?>[] types() default {};
    Class<?>[] excludes() default {};
}