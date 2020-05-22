@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockOAuth2ScopeSecurityContextFactory.class)
public @interface WithMockOAuth2Scope {

    String token() default "";

    String clientId() default "client-id";

    boolean approved() default true;

    String redirectUrl() default "";

    String[] responseTypes() default {};

    String[] scopes() default {};

    String[] resourceIds() default {};

    String[] authorities() default {};

    String username() default "username";

    String password() default "";

    String email() default "";
}