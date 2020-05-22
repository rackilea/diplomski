@RunWith(MockitoJUnitRunner.class)
public class UsersHolderTest {
    @InjectMocks private UsersHolder usersHolder;
    @Mock private Set<User> users;

    @Test
    public void addUser_shouldAddUser() {
        // given
        User user = new User();
        // when
        usersHolder.addUser(user);
        // then
        Mockito.verify(usersHolder).add(user);
    }
}