import javax.ws.rs.core;
//
public ObjectList read(
    @PathParam("id") Integer id,
    @Context SecurityContext sc) {
    String principalUserName = sc.getUserPrincipal().getName();
    if (sc.isUserInRole("MyRole")) {
        return new MyRoleResource();
    } else {
        return new MyDefaultRoleResource();
    }
}