public class RuntimeExceptionRestMapper implements ExceptionMapper<RuntimeException> {

    public Response toResponse(RuntimeException exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                //handle your response
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(exception.getMessage())
                .build();
    }

}