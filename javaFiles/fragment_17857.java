@GET
@Produces("application/json")
public List<Campus> getCampusListJSON() {

  List<Campus> campuses = campusService_.getCampusList();

  if(campuses.isEmpty()) {
     throw new WebApplicationException(Response.Status.NOT_FOUND);
   }

   return campuses;
}