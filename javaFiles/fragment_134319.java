@GET
@Produces(MediaType.TEXT_XML)
@Path("/directgroups")
public Groups getDirectGroupsForUser(@PathParam("userId") String userId) {
    try {

        Groups groups = new Groups();
        groups.getGroup().addAll(service.getDirectGroupsForUser(userId, null, true));
        return groups;
    } catch (UserServiceException e) {
        LOGGER.error(e);
        throw new RuntimeException(e.getMessage());
    }
}