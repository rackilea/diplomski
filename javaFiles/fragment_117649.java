@GET
public String get(@QueryParam("count") int count, @ErrorParam Map<String, String> errors) {
    if (!errors.isEmpty()) {
        throw new WebApplicationException(...whatever response you want to generate...);
    }
    ... do whatever you want to do if parameters are fine ...
}