@Override
public void run(
        final Configuration config,
        final Environment environment) throws Exception {
    ((DefaultServerFactory)config.getServerFactory()).setRegisterDefaultExceptionMappers(false);
    // Register custom mapper
    environment.jersey().register(new MyConstraintViolationExceptionMapper());
    // Restore Dropwizard's exception mappers
    environment.jersey().register(new LoggingExceptionMapper<Throwable>() {});
    environment.jersey().register(new JsonProcessingExceptionMapper());
    environment.jersey().register(new EarlyEofExceptionMapper());
    ...
}

@Provider
public class MyConstraintViolationExceptionMapper 
        implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
    ...
    }
}