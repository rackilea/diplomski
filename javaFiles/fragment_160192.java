public MyRestApplication() 
{

    System.out.println("Entering Custom Application");

    property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    // @ValidateOnExecution annotations on subclasses won't cause errors.
    property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
    register(RolesAllowedDynamicFeature.class);
    register(AuthenticationFilter.class);
    register(AuthenticationResponseFilter.class);
 }