@RunWith(MockitoJUnitRunner.class)
public class UserFactoryTest {

    @Mock
    private Map<String, User> UserMap;

    @InjectMocks
    private UserFactory UserFactory;

    private String userId = "123";


    @Test
    public void getUser(){
       when(UserMap.get(userId)).thenReturn(userService);
       userService actual = userServiceFactory.getUser(userId);
       assertEquals(UserMap.get(userId), actual);
    }


    @Test
    public void getUser_with_unknown_userId(){
        Assertions.assertThrows(IllegalArgumentException.class, 
                            ()->  userServiceFactory.getUser(userId));
    }

}