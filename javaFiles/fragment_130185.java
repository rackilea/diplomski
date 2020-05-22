@RunWith(SpringRunner.class)
@DataJpaTest
@Import(DuplicatedUsernameValidator.class)
public class DuplicatedUsernameValidatorTest {

    @Aurowired
    private DuplicatedUsernameValidator validator;

    @MockBean
    private UserRepository repository; 

    public void givenDuplicatedSettings_whenValidate_thenReturnInvalid() {
        String username = "duplicated";

        User user = new User(username);

        when(repository.findByUsername(username))
                .thenReturn(new User(username));

        assertFalse(validator.isValid(user));
    }
}