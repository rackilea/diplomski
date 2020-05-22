public class UserResourceTest {

  @Test
  public void test() {
    //Arrange
    boolean expected = true; 
    DbResponse mockResponse = mock(DbResponse.class);
    when(mockResponse.isSuccess).thenReturn(expected);

    User user = mock(User.class);
    UserService mockService = mock(UserService.class);
    when(mockService.addUser(user)).thenReturn(mockResponse);

    UserResource userResource = new UserResource(mockService);        

    //Act
    boolean actual = userResource.createUser(user);

    //Assert
    assert(expected == actual);
  }
}