@Documented
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface Authorized {
    public String[] value() default "";
}