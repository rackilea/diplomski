/** 
 * @param param0 Paging parameter
 * @param param1 Paging parameter
 * */
@Path("list-all")
@GET
@RBAC(type = { CRUDEnum.READ }, capability = { "PowerUser" })
@ParseContext
@Produces( {
        "application/json",
        "application/xml"})
public net.myapp.services getAllDevices(
        @QueryParam("start") int param0, @QueryParam("limit") int param1);