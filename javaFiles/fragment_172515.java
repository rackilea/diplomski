@GET
@Path("/{id}/{name}")
@Produces({MediaType.APPLICATION_XML})
public Person fetchPerson(
          @PathParam("id") Integer id,
          @PathParam("name") String name) {
    return personService.fetchPerson(id);
}