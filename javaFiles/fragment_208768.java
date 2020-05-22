@Target( { TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
@Qualifier
public @interface ConfigurableQualifier {

    @Nonbinding
    int value() default 0;
}