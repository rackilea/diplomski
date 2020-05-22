@RunWith(MockitoJUnitRunner.class)
public class UsersControllerTest {

    @InjectMocks
    private UsersController usersController;

    @Mock
    private EntityManager entityManagerMock;

    @Mock
    private EntityManagerFactory entityManagerFactory;

    @Mock
    private Cache emfCache;

    @Mock
    private Query findAllQuery;

    private List<User> mockUsersDbCollection = //...

    @Before
    public void setUp() {
        when(entityManagerFactory.getCache())
            .thenReturn(emfCache);
        when(entityManagerMock.getEntityManagerFactory())
            .thenReturn(entityManagerFactory);
        when(entityManagerMock.createNamedQuery("User.findAll"))
            .thenReturn(findAllQuery);
        when(findAllQuery.getResultList())
            .thenReturn(mockUsersDbCollection);
    }

    @Test
    public void findOneTest(){
        mockUsersDbCollection.add(new User("1", "pa$$word", "salt", "user1", "user1@email.com", false));

        User returnedUser = usersController.getOne();

        assertEquals(returnedUser.getId(), "1");
    }
}