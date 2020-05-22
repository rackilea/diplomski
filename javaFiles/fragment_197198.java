@RunWith(SpringRunner.class)
@SpringBootTest
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ActiveProfiles("test")
public class StudySecurityTest {

    @Autowired
    private StudyService service;

    @MockBean
    private StudyRepository repository;

    @Test
    @WithAnonymousUser
    public void testAsAnonymous() {
        ...
    }

    @Test
    @WithMockKeycloakUser(id = LOGGED_USER_ID, username = LOGGED_USER_USERNAME, authorities = { "ROLE_USER" })
    public void testAsUser() {
        ...
    }
}