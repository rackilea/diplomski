class FooResource extends Resource {
    @GET
    public FooRepresentation get() {
        return new FooRepresentation();
    }
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postForm(MulivaluedMap<String, String> form) {
        return post(buildRepresentationFromForm(form));
    }
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Resopnse post(FooRepresentation representation) {
         // return ok, see other, whatever
    }
}