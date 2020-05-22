import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserService_doesUserIdExistTests
{

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void compareDuplicateUserIdTest() {

        String lowercase = "test";

        // Mocking the response for your method that uses external dependencies 
        when(userRepository.findOne(lowercase)).thenReturn(true); // You can mock the response you want using .thenReturn(...)

        // Test your userService method (you can also debug it if needed)
        boolean result = userService.doesUserIdExist(lowercase);

        //Check the boolean result if its true
        assertTrue(result);
    }
}