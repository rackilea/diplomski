public class Greeter {

  @Context
  SecurityContext sc;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String sayHello() {

    // this will set the user id as userName
    String userName = sc.getUserPrincipal().getName();

    if (sc.getUserPrincipal() instanceof KeycloakPrincipal) {
      KeycloakPrincipal<KeycloakSecurityContext> kp = (KeycloakPrincipal<KeycloakSecurityContext>)  sc.getUserPrincipal();

      // this is how to get the real userName (or rather the login name)
      userName = kp.getKeycloakSecurityContext().getIdToken().getPreferredUsername();
    }

    return "{ message : \"Hello " + userName + "\" }";
}