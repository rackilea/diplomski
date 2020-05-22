public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserDao mockUserRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindUser(){
        // Given
        User dummyUser = new User();
        when(mockUserRepository.findByLoginAndPassword(anyString(), anyString()).thenReturn(dummyUser);

        // When
        User result = userService.findUser("first", "teste");

        // Then
        // you are expecting service to return whatever returned by repo
        assertThat("result", result, is(sameInstance(dummUser)));

        // you are expecting repo to be called once with correct param
        verify(mockUserRepository).findByLoginAndPassword("first", "teste");
    }
}