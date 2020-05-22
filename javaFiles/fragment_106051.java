@GET
@Produces(MediaType.APPLICATION_XML)
@Path("/{typeDocument}")
public MyObject getXml(@PathParam("typeDocument") String typeDocument) {
 myObjectService.get(typeDocument);
}


@XmlRootElement(name="myObject")
public class MyObject {
// Some properties
}