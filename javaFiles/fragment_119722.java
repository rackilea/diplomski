@POST
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public Role createRole(@ModelParam Role role) throws JSONException
{
  return userService.createRole(role);
}