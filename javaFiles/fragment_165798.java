// IPersonService.java
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

@GET
@Path("/person/{id}")
Response getPerson(@PathParam("id") String id, @Context Request request);


// PersonServiceImpl.java
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public Response getPerson(String name, Request request) {
  Person person = _dao.getPerson(name);

  if (person == null) {
    return Response.noContent().build();
  }

  EntityTag eTag = new EntityTag(person.getUUID() + "-" + person.getVersion());

  CacheControl cc = new CacheControl();
  cc.setMaxAge(600);

  ResponseBuilder builder = request.evaluatePreconditions(person.getUpdated(), eTag);

  if (builder == null) {
    builder = Response.ok(person);
  }

  return builder.cacheControl(cc).lastModified(person.getUpdated()).build();
}