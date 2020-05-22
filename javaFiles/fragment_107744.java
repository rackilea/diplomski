@Context
private ResourceContext resourceContext;

@Path("{id}")
public ManufacturerResource getManufacturer(@PathParam("id") String id) {
    ManufacturerResource r = resourceContext.getResource(ManufacturerResource.class);
    r.setId(id);
    return r;
}