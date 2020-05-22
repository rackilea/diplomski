@Provider
public class MyWrapperExceptionMapper implements ExceptionMapper<MyWrapperException> {
    @Context
    private Providers providers;

    public Response toResponse(MyWrapperException e) {
        Throwable t = e.getCause();
        ExceptionMapper mapper = providers.getExceptionMapper(t.getClass());
        if( mapper != null ) {
            return mapper.toResponse(t);
        }
        else {
            // custom handling...
        }
    }
}