@GET
@Produces("application/xml")
public Campuses getCampusListXML() {

  List<Campus> campuses = campusService_.getCampusList();

  if(campuses.isEmpty()) {
     throw new WebApplicationException(Response.Status.NOT_FOUND);
   }

   Campuses response = new Campuses();
   response.setCampuses(campuses);
   return response;
}