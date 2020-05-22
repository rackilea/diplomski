@GET
@Path("/hello")
@Produces("text/html")
public String hello(@RequestBody String payload) {

    return "OK";
}