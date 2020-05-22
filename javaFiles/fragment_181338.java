public class MySqlDataTruncationExceptionMapper implements ExtendedExceptionMapper<HibernateException> {

    @Override
    public boolean isMappable(HibernateException top) {
        return top.getCause() instanceof MySqlDataTruncation;
    }

    @Override
    public Response toResponse(HibernateException top) {
        MySqlDataTruncation e = (MySqlDataTruncation) top.getCause();
        // No possibility of a ClassCastException because we already checked
        // that `top.getCause() instanceof MySqlDataTruncation`

        // Do stuff with `e` to return a response:
        return Response.status(Status.REQUEST_ENTITY_TOO_LARGE).entity(e.getMessage()).build();
    }
}