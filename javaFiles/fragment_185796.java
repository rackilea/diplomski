@NameBinding
@Target({METHOD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Status {
    int DEFAULT_CODE = 0;

    int code() default DEFAULT_CODE;
}