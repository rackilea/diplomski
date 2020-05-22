// Web server passes GET localhost/widgets/{id} calls to this method.
public Widget getWidgetById(Long id) {
    Widget w = new Widget();
    try {
        // Ask the DB for the Widget with the passed-in 'id'. If it exist return it.
        // Otherwise return NULL.
    } catch(NotFoundException e) {
        throw new NotFoundException(Response.status(Response.Status.NOT_FOUND)
                .entity("Widget " + id + " not found.").build());
    } catch(Exception e) {
        throw new WebApplicationException(Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("I don't know what happened, but trying again won't help: "
                        + e.getMessage())
                .build());

    }

    return w;           
}