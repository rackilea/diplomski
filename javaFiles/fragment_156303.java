public class TestUserAccess {

  private static final String SERVER_URL = "http://localhost:8080/auth";
  private static final String REALM = "master";
  private static final String USERNAME = "admin";
  private static final String PASSWORD = "secret";
  private static final String CLIENT_ID = "admin-cli";

  public static void main(String[] args) {

    Keycloak keycloak = KeycloakBuilder
        .builder()
        .serverUrl(SERVER_URL)
        .realm(REALM)
        .username(USERNAME)
        .password(PASSWORD)
        .clientId(CLIENT_ID)
        .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build())
        .build();

    UsersResource usersResource = keycloak.realm(REALM).users();
    UserResource userResource = usersResource.get("08afb701-fae5-40b4-8895-e387ba1902fb");
    System.out.println(userResource.toRepresentation().getEmail());
  }
}