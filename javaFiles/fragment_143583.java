@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {


    @Mock
    private AccountRepository accountRepositoryMock;

    @Mock
    private BlogRepository blogRepository;

    @Mock
    private ImageService imageService;

    @InjectMocks
    private AccountService accountService ;

    @Test
    public void shouldInitializeWithTwoDemoUsers() throws IOException {
        // act
        accountService.initialize();
        // assert
        verify(accountRepositoryMock, times(2)).save(any(Account.class));
    }

}