public class RestTest extends JerseyTest{

@Override
protected Application configure() {

    return new Your_Resource_Config(); //Your resource config with registered classes
}

//@Before and/or @After for db preparing etc. - if you want integration tests

@Test
public void addUserTest() {
    User user = new User();
    user.setEmail("user2@mail.com");
    user.setName("Jane Doe");
    user.getUserRoles().getRoles().add("supertester");
    Entity<User> userEntity = Entity.entity(user, MediaType.APPLICATION_XML_TYPE);
    target("users/add").request().post(userEntity); //Here we send POST request
    Response response = target("users/find").queryParam("email", "user2@mail.com").request().get(); //Here we send GET request for retrieving results
    Assert.assertEquals("user2@mail.com", response.readEntity(User.class).getEmail());

}