@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles(value = {SPRING_PROFILE_TEST})
public class UserControllerTest {
    @Autowired
    private UserController UserController; //confirm controller can be autowired