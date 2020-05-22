@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Authorize {
    /**
     * Roles to authorize. By default, any of the roles specified
     * will be accepted as authorization
     */
    String[] value() default {};

    /**
     * Roles to authorize. Any matched role in the list will be accepted
     * as authorization.
     */
    String[] anyOf() default {};

    /**
     * Roles to authorize. All roles in the list must match to be accepted
     * as authorization.
     */
    String[] allOf() default {};
}